import streamlit as st
import pandas as pd
import pickle
import numpy as np

# Load the trained model
def load_model():
    # Ensure you have re-trained this model after setting index=False in your CSV
    with open("model.pkl", "rb") as file:
        model = pickle.load(file)
    return model

# Initialize model
try:
    model = load_model()
except FileNotFoundError:
    st.error("Model file 'model.pkl' not found. Please train and save your model first.")
    st.stop()

# Page configuration
st.set_page_config(page_title="Cardiovascular Disease Predictor", layout="centered")

st.title("❤️ Cardio Health Predictor")
st.write("Enter the patient details below to predict the risk of cardiovascular disease.")

# Create the form for user input
with st.form("prediction_form"):
    col1, col2 = st.columns(2)
    
    with col1:
        age_years = st.number_input("Age (Years)", min_value=1, max_value=120, value=50)
        gender = st.selectbox("Gender", options=[1, 2], format_func=lambda x: "Female" if x == 1 else "Male")
        height = st.number_input("Height (cm)", min_value=50, max_value=250, value=170)
        weight = st.number_input("Weight (kg)", min_value=10, max_value=300, value=70)
        ap_hi = st.number_input("Systolic Blood Pressure (ap_hi)", min_value=50, max_value=250, value=120)
        ap_lo = st.number_input("Diastolic Blood Pressure (ap_lo)", min_value=30, max_value=150, value=80)

    with col2:
        cholesterol = st.selectbox("Cholesterol Level", options=[1, 2, 3], 
                                   format_func=lambda x: ["Normal", "Above Normal", "Well Above Normal"][x-1])
        gluc = st.selectbox("Glucose Level", options=[1, 2, 3], 
                             format_func=lambda x: ["Normal", "Above Normal", "Well Above Normal"][x-1])
        smoke = st.radio("Do you smoke?", options=[0, 1], format_func=lambda x: "No" if x == 0 else "Yes")
        alco = st.radio("Alcohol consumption?", options=[0, 1], format_func=lambda x: "No" if x == 0 else "Yes")
        active = st.radio("Physical activity?", options=[0, 1], format_func=lambda x: "No" if x == 0 else "Yes")

    submit = st.form_submit_button("Predict Result")

if submit:
    # 1. Preprocess inputs to match the notebook's logic
    # Calculate BMI exactly as done in cell 13
    bmi = round(weight / ((height / 100) ** 2), 1)
    
    # 2. Construct the DataFrame with exact feature names and order from training
    # Order: gender, ap_hi, ap_lo, cholesterol, gluc, smoke, alco, active, age_years, bmi
    input_data = pd.DataFrame([[
        gender,
        ap_hi,
        ap_lo,
        cholesterol,
        gluc,
        smoke,
        alco,
        active,
        age_years,
        bmi
    ]], columns=['gender', 'ap_hi', 'ap_lo', 'cholesterol', 'gluc', 'smoke', 'alco', 'active', 'age_years', 'bmi'])

    try:
        # 3. Make Prediction
        prediction = model.predict(input_data)
        probability = model.predict_proba(input_data)[0][1]

        # 4. Display Results
        st.divider()
        if prediction[0] == 1:
            st.error(f"### Result: High Risk of Cardiovascular Disease")
            st.write(f"Confidence: {probability:.2%}")
        else:
            st.success(f"### Result: Low Risk of Cardiovascular Disease")
            st.write(f"Confidence: {1 - probability:.2%}")
            
        st.info(f"Calculated BMI: {bmi}")
        
    except ValueError as e:
        st.error(f"Prediction Error: {e}")
        st.warning("The model features don't match. Ensure you re-trained the model after saving the CSV with index=False.")