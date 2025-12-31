import streamlit as st
import pandas as pd
import numpy as np
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import BaggingClassifier
from sklearn.model_selection import train_test_split

# --- PAGE CONFIG ---
st.set_page_config(page_title="Cardio Health Predictor", layout="wide")

# --- DATA LOADING & MODEL TRAINING ---
@st.cache_resource
def train_model():
    # Loading the final dataset created in your Preprocess notebook
    # Note: Ensure 'Final_Data_Set.csv' is in the same folder
    try:
        data = pd.read_csv('Final_Data_Set.csv')
        if 'Unnamed: 0' in data.columns:
            data = data.drop(columns=['Unnamed: 0'])
    except FileNotFoundError:
        st.error("Dataset 'Final_Data_Set.csv' not found. Please run your preprocessing notebook first.")
        return None

    # Features and Target
    X = data.drop('cardio', axis=1)
    y = data['cardio']

    # Train-test split (matching your Training.ipynb)
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    # Model definition
    base_model = DecisionTreeClassifier(random_state=42)
    model = BaggingClassifier(estimator=base_model, n_estimators=10, random_state=42)
    model.fit(X_train, y_train)
    
    return model, X.columns

# Initialize model
model_data = train_model()

if model_data:
    model, feature_columns = model_data

    # --- UI LAYOUT ---
    st.title("❤️ Cardiovascular Disease Prediction")
    st.markdown("Enter the patient details below to predict the risk of cardiovascular disease.")

    with st.sidebar:
        st.header("Patient Metrics")
        gender = st.selectbox("Gender", options=[1, 2], format_func=lambda x: "Female" if x==1 else "Male")
        age_years = st.slider("Age (Years)", 30, 80, 50)
        height = st.number_input("Height (cm)", 100, 250, 170)
        weight = st.number_input("Weight (kg)", 30, 200, 70)
        
        # Calculate BMI automatically (matching your Preprocess logic)
        bmi = round(weight / ((height / 100)**2), 1)
        st.info(f"Calculated BMI: {bmi}")

    # Main Input Area
    col1, col2 = st.columns(2)

    with col1:
        ap_hi = st.number_input("Systolic Blood Pressure (ap_hi)", 80, 200, 120)
        ap_lo = st.number_input("Diastolic Blood Pressure (ap_lo)", 50, 120, 80)
        cholesterol = st.selectbox("Cholesterol Level", [1, 2, 3], format_func=lambda x: ["Normal", "Above Normal", "Well Above Normal"][x-1])

    with col2:
        gluc = st.selectbox("Glucose Level", [1, 2, 3], format_func=lambda x: ["Normal", "Above Normal", "Well Above Normal"][x-1])
        smoke = st.checkbox("Smoker?")
        alco = st.checkbox("Alcohol Intake?")
        active = st.checkbox("Physically Active?", value=True)

    # --- PREDICTION LOGIC ---
    if st.button("Predict Health Risk", type="primary"):
        # Map inputs to feature vector
        # Note: We must follow the exact order of columns from Training.ipynb
        # Columns: ['gender', 'ap_hi', 'ap_lo', 'cholesterol', 'gluc', 'smoke', 'alco', 'active', 'age_years', 'bmi']
        
        input_data = pd.DataFrame([[
            gender, ap_hi, ap_lo, cholesterol, gluc, 
            int(smoke), int(alco), int(active), age_years, bmi
        ]], columns=feature_columns)

        prediction = model.predict(input_data)[0]
        probability = model.predict_proba(input_data)[0][1]

        st.divider()
        if prediction == 1:
            st.error(f"### High Risk Detected")
            st.write(f"The model predicts a **{probability*100:.1f}%** likelihood of cardiovascular disease.")
        else:
            st.success(f"### Low Risk Detected")
            st.write(f"The model predicts a **{(1-probability)*100:.1f}%** likelihood of being healthy.")

    # --- DATA EXPLORATION ---
    with st.expander("View Training Data Sample"):
        df_sample = pd.read_csv('Final_Data_Set.csv')
        st.dataframe(df_sample.head(10))