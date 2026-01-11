import streamlit as st
import pandas as pd
import pickle
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
import warnings
import os
import base64

# Suppress warnings
warnings.filterwarnings("ignore")

# Page configuration
st.set_page_config(
    page_title="Cardiolife | Smart Health AI",
    page_icon="💓",
    layout="wide",
    initial_sidebar_state="expanded"
)

# --- ADVANCED CSS STYLING ---
st.markdown("""
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap');
    
    html, body, [class*="css"]  {
        font-family: 'Inter', sans-serif;
        color: #333;
    }
    
    /* ANIMATIONS */
    @keyframes slideIn {
        from { opacity: 0; transform: translateX(-20px); }
        to { opacity: 1; transform: translateX(0); }
    }
    .main-content {
        animation: slideIn 0.5s ease-out;
    }
    
    /* SIDEBAR STYLING - MODERN MENU */
    [data-testid="stSidebar"] {
        background-color: #0f172a;
    }
    [data-testid="stSidebar"] * {
        color: #e2e8f0;
    }
    
    /* Hide Radio Circles */
    [data-testid="stSidebar"] [data-testid="stMarkdownContainer"] p {
        font-size: 1.1rem;
        padding: 5px 0;
    }
    section[data-testid="stSidebar"] .stRadio > div[role="radiogroup"] > label {
        background-color: transparent;
        border: 1px solid transparent;
        border-radius: 8px;
        padding: 10px 15px;
        margin-bottom: 5px;
        transition: all 0.3s;
    }
    section[data-testid="stSidebar"] .stRadio > div[role="radiogroup"] > label:hover {
        background-color: rgba(255, 255, 255, 0.1);
        cursor: pointer;
    }
    /* Highlight Selected */
    section[data-testid="stSidebar"] .stRadio > div[role="radiogroup"] > label[data-checked="true"] {
        background-color: #3b82f6; /* Blue highlight */
        color: white;
        font-weight: bold;
        box-shadow: 0 4px 6px rgba(0,0,0,0.2);
    }
    div[data-testid="stSidebar"] .stRadio div[role="radiogroup"] label div:first-child {
        display: none; 
    }

    /* CUSTOM CARDS */
    .feature-card {
        background: white;
        padding: 2rem;
        border-radius: 12px;
        box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
        border-top: 5px solid #3b82f6;
        height: 100%;
    }
    .stat-card {
        background: linear-gradient(135deg, #4f46e5 0%, #3b82f6 100%);
        color: white;
        padding: 20px;
        border-radius: 12px;
        text-align: center;
    }
    .stat-card h2 { color: white !important; margin: 0; }
    
    /* HEADINGS */
    h1 {
        background: linear-gradient(90deg, #1e293b, #3b82f6);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        font-weight: 800;
        margin-bottom: 1rem;
    }
    
    /* ABOUT PAGE PROFILE START */
    .profile-container {
        display: flex;
        flex-direction: row;
        background-color: white;
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.08);
        align-items: center;
        gap: 40px;
        margin-top: 20px;
        border-left: 8px solid #3b82f6;
    }
    .profile-img {
        width: 180px;
        height: 180px;
        border-radius: 50%;
        object-fit: cover;
        border: 5px solid #e2e8f0;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
    }
    .profile-info h1 {
        margin: 0;
        font-size: 2rem;
        color: #1e293b;
        background: none;
        -webkit-text-fill-color: #1e293b;
    }
    .profile-info h3 {
        color: #64748b;
        font-weight: 500;
        margin-bottom: 20px;
    }
    .contact-badges {
        display: flex;
        gap: 15px;
        flex-wrap: wrap;
    }
    .badge {
        background-color: #f1f5f9;
        padding: 8px 15px;
        border-radius: 50px;
        font-size: 0.9rem;
        color: #334155;
        display: flex;
        align-items: center;
        gap: 8px;
        font-weight: 600;
        border: 1px solid #e2e8f0;
    }
    /* ABOUT PAGE PROFILE END */
    
    </style>
    """, unsafe_allow_html=True)

# --- Data & Model Loading ---
@st.cache_resource
def load_assets():
    try:
        with open("model.pkl", "rb") as model_file:
            model = pickle.load(model_file)
        with open("scaler.pkl", "rb") as scaler_file:
            scaler = pickle.load(scaler_file)
        return model, scaler
    except:
        return None, None

@st.cache_data
def load_data():
    try:
        df = pd.read_csv("Final_Data_Set.csv")
        return df
    except:
        return None

model, scaler = load_assets()
df = load_data()

# --- Page Functions ---

def page_home():
    st.markdown("<div class='main-content'>", unsafe_allow_html=True)
    
    # Hero
    col1, col2 = st.columns([1.2, 0.8])
    with col1:
        st.title("Future of Heart Health")
        st.markdown("### AI-Powered Risk Assessment Platform")
        st.write("""
        **Cardiolife** bridges the gap between patient data and medical insight. 
        Using advanced machine learning, we interpret complex health patterns to identify 
        cardiovascular risks instantly.
        """)
        st.write("")
        st.info("👈 Select **'Clinical Diagnostics'** from the sidebar to start a prediction.")
    with col2:
        st.image("https://img.freepik.com/free-vector/human-heart-anatomy_1308-96695.jpg", use_container_width=True)

    st.markdown("---")

    # Features
    st.subheader("Why Choose Cardiolife?")
    c1, c2, c3 = st.columns(3)
    with c1:
        st.markdown("""
        <div class="feature-card">
            <h3>⚡ Instant Analysis</h3>
            <p>Get immediate risk probability scores using our optimized Random Forest engine. No waiting time, just results.</p>
        </div>
        """, unsafe_allow_html=True)
    with c2:
        st.markdown("""
        <div class="feature-card">
            <h3>🧠 Smart Technology</h3>
            <p>Trained on 70,000+ data points involving age, BP, cholesterol, and lifestyle habits for maximum reliability.</p>
        </div>
        """, unsafe_allow_html=True)
    with c3:
        st.markdown("""
        <div class="feature-card">
            <h3>🛡️ Privacy Focused</h3>
            <p>Your health data is processed in real-time for prediction and is never stored permanently on our servers.</p>
        </div>
        """, unsafe_allow_html=True)

    st.markdown("---")
    st.markdown("</div>", unsafe_allow_html=True)

def page_data_insights():
    st.markdown("<div class='main-content'>", unsafe_allow_html=True)
    st.title("📊 Data Analytics Dashboard")
    
    if df is None:
        st.error("Dataset not unavailable.")
        return

    # Top Level Stats
    s1, s2, s3, s4 = st.columns(4)
    s1.metric("Dataset Size", f"{len(df):,}")
    s2.metric("Features", f"{df.shape[1]}")
    s3.metric("Avg Age", f"{df['age_years'].mean():.1f} yrs")
    mode_chol = df['cholesterol'].mode()[0]
    chol_map = {1: "Normal", 2: "Above Normal", 3: "High"}
    s4.metric("Avg Cholesterol", chol_map.get(mode_chol, "N/A")) 

    st.markdown("### Interactive Exploration")
    tabs = st.tabs(["Distributions", "Vitals Breakdown", "Correlations", "Health Metrics"])

    with tabs[0]:
        c1, c2 = st.columns(2)
        with c1:
            st.markdown("**Age Demographics**")
            fig, ax = plt.subplots(figsize=(6, 3))
            sns.histplot(df['age_years'], kde=True, color="#3b82f6", bins=25, ax=ax)
            ax.set_xlabel("Age (Years)")
            st.pyplot(fig)
        with c2:
            st.markdown("**Gender Distribution**")
            fig_g, ax_g = plt.subplots(figsize=(6, 3))
            gender_cnt = df['gender'].value_counts()
            ax_g.pie(gender_cnt, labels=['Male', 'Female'] if 2 in gender_cnt.index else gender_cnt.index, autopct='%1.1f%%', colors=['#3b82f6', '#ec4899'])
            st.pyplot(fig_g)

    with tabs[1]:
        st.markdown("**Clinical Levels Analysis**")
        c1, c2 = st.columns(2)
        with c1:
            st.markdown("Cholesterol Levels")
            fig_c, ax_c = plt.subplots(figsize=(6, 3))
            sns.countplot(x=df['cholesterol'], palette="viridis", ax=ax_c)
            ax_c.set_xticklabels(["Normal", "Above Normal", "High"])
            st.pyplot(fig_c)
        with c2:
            st.markdown("Glucose Levels")
            fig_gl, ax_gl = plt.subplots(figsize=(6, 3))
            sns.countplot(x=df['gluc'], palette="magma", ax=ax_gl)
            ax_gl.set_xticklabels(["Normal", "Above Normal", "High"])
            st.pyplot(fig_gl)

    with tabs[2]:
        st.caption("How different factors correlate with each other.")
        fig_corr, ax_corr = plt.subplots(figsize=(8, 4))
        numeric_cols = df.select_dtypes(include=[np.number]).columns
        corr = df[numeric_cols].corr()
        sns.heatmap(corr, annot=True, fmt=".2f", cmap="coolwarm", ax=ax_corr, annot_kws={"size": 8})
        st.pyplot(fig_corr)

    with tabs[3]:
        st.caption("Detailed breakdown of health indicators.")
        st.markdown("**BMI vs Disease Presence**")
        
        plot_df = df.copy()
        if 'bmi' not in plot_df.columns:
            if 'weight' in plot_df.columns and 'height' in plot_df.columns:
                plot_df['bmi'] = plot_df['weight'] / ((plot_df['height']/100)**2)
        
        if 'bmi' in plot_df.columns:
            plot_df['Condition'] = plot_df['cardio'].map({0: 'Healthy', 1: 'Disease'})
            
            fig3, ax3 = plt.subplots(figsize=(8, 3))
            sns.boxplot(data=plot_df, x='Condition', y='bmi', palette={'Healthy': '#10b981', 'Disease': '#f43f5e'}, ax=ax3)
            ax3.set_title("BMI Range by Condition")
            st.pyplot(fig3)
        else:
            st.warning("BMI data not available for plotting.")
            
    st.markdown("</div>", unsafe_allow_html=True)

def page_advice():
    st.markdown("<div class='main-content'>", unsafe_allow_html=True)
    st.title("🥗 Heart Health Advice")
    
    with st.expander("🍎 Nutritional Guidelines", expanded=True):
        st.markdown("""
        - **Eat More**: Fruits, vegetables, whole grains, nuts, legumes.
        - **Eat Less**: Red meats, sodium (salt), sugary beverages, processed carbs.
        - **Hydration**: Drink at least 8 glasses of water daily.
        """)
    
    with st.expander("🏃 Physical Activity"):
        st.markdown("""
        - **Cardio**: 150 minutes of moderate activity (brisk walking) per week.
        - **Strength**: Muscle-strengthening activities on 2 days a week.
        - **Routine**: Take the stairs, walk during breaks, stand while working.
        """)
        
    with st.expander("🧘 Stress & Sleep"):
        st.markdown("""
        - **Sleep**: Aim for 7-9 hours of quality sleep per night.
        - **Relaxation**: Practice deep breathing or meditation for 10 minutes daily.
        """)
    
    st.info("Remember: Consult your consulting physician before making drastic lifestyle changes.")
    st.markdown("</div>", unsafe_allow_html=True)

def page_prediction():
    st.markdown("<div class='main-content'>", unsafe_allow_html=True)
    st.title("🩺 Clinical Diagnostics")
    st.markdown("Enter patient metrics for real-time analysis.")

    with st.form("pred_form"):
        st.markdown("### 👤 Patient Information")
        c1, c2, c3, c4 = st.columns(4)
        age = c1.number_input("Age", 30, 100, 50)
        gender = c2.selectbox("Gender", ["Female", "Male"])
        height = c3.number_input("Height (cm)", 100, 220, 170)
        weight = c4.number_input("Weight (kg)", 40, 180, 70)

        st.markdown("### ❤️ Clinical Vitals")
        vc1, vc2, vc3, vc4 = st.columns(4)
        ap_hi = vc1.number_input("Systolic BP", 80, 240, 120, help="Upper reading")
        ap_lo = vc2.number_input("Diastolic BP", 50, 150, 80, help="Lower reading")
        chol = vc3.selectbox("Cholesterol", ["Normal", "Above Normal", "High"])
        gluc = vc4.selectbox("Glucose", ["Normal", "Above Normal", "High"])

        st.markdown("### 🏃 Lifestyle")
        lc1, lc2, lc3 = st.columns(3)
        smoke = lc1.checkbox("Smoker")
        alco = lc2.checkbox("Alcohol Consumer")
        active = lc3.checkbox("Physically Active")

        st.markdown("<br>", unsafe_allow_html=True)
        submit = st.form_submit_button("🛡️ Run Risk Analysis", type="primary", use_container_width=True)

    if submit and model:
        # Prep Data
        gen_val = 1 if gender == "Female" else 2
        chol_map = {"Normal": 1, "Above Normal": 2, "High": 3}
        gluc_map = {"Normal": 1, "Above Normal": 2, "High": 3}
        bmi = round(weight / ((height/100)**2), 2)
        
        input_vector = pd.DataFrame([[
            gen_val, ap_hi, ap_lo, chol_map[chol], gluc_map[gluc], 
            int(smoke), int(alco), int(active), age, bmi
        ]], columns=['gender', 'ap_hi', 'ap_lo', 'cholesterol', 'gluc', 'smoke', 'alco', 'active', 'age_years', 'bmi'])

        try:
            scaled_vec = scaler.transform(input_vector)
            prob = model.predict_proba(scaled_vec)[0][1]
            
            st.divider()
            st.subheader("Analysis Results")
            
            r1, r2 = st.columns([1, 2])
            with r1:
                st.markdown(f"""
                <div class="stat-card" style="background: {'#f43f5e' if prob > 0.5 else '#10b981'};">
                    <h2>{prob:.1%}</h2>
                    <p>Risk Probability</p>
                </div>
                """, unsafe_allow_html=True)
            
            with r2:
                if prob > 0.5:
                    st.error("⚠️ **High Probability of Cardiovascular Disease detected.**")
                    st.markdown("We strongly recommend consulting a medical professional.")
                    
                    # Button to show advice
                    st.write("")
                    st.info("👇 Click below for immediate lifestyle recommendations.")
                    if st.button("🥗 View Health Advice Now"):
                        st.session_state.navigation = "🥗 Health Advice"
                        st.rerun()
                else:
                    st.success("✅ **Patient appears to be in a healthy range.**")
                    st.markdown("""
                    **Recommendations:**
                    - Maintain current healthy lifestyle.
                    - Continue regular yearly checkups.
                    - Ensure at least 150 minutes of moderate activity per week.
                    """)
            
        except Exception as e:
            st.error(f"Prediction Error: {e}")

    st.markdown("</div>", unsafe_allow_html=True)

def page_model_stats():
    st.markdown("<div class='main-content'>", unsafe_allow_html=True)
    st.title("📈 Model Evaluation")
    
    st.markdown("""
    <div class="feature-card">
        <h3>Random Forest Classifier</h3>
        <p>
            This model was selected after rigorous testing. It builds multiple decision trees and merges them together 
            to get a more accurate and stable prediction.
        </p>
    </div>
    <br>
    """, unsafe_allow_html=True)
    
    st.subheader("🛠️ Model Development Process")
    st.markdown("""
    1. **Data Collection**: Sourced 70,000 records from verified medical databases (Kaggle).
    2. **Preprocessing**: Removed duplicates, handled outliers in Blood Pressure data, and normalized Body Mass Index (BMI).
    3. **Training**: Used 80% of data to train a Random Forest estimator with 200 trees.
    4. **Testing**: Validated on remaining 20% distinct data to ensure no overfitting.
    """)

    st.subheader("🥊 Algorithm Comparison")
    st.caption("Why we chose Random Forest:")
    
    comp_data = {
        "Algorithm": ["Logistic Regression", "Decision Tree", "Random Forest (Ours)", "Support Vector Machine"],
        "Accuracy": ["72.1%", "64.5%", "73.8%", "72.5%"],
        "Pros": ["Fast, Simple", "Easy to Interpret", "High Accuracy, Robust", "Effective in High Dimensions"],
        "Cons": ["Prone to Underfitting", "Prone to Overfitting", "Computationally Heavy", "Slow Training"]
    }
    st.table(pd.DataFrame(comp_data))
    
    st.divider()
    
    if st.button("Run Live Evaluation on Current Dataset"):
        with st.spinner("Calculating performance..."):
            try:
                X = df[['gender', 'ap_hi', 'ap_lo', 'cholesterol', 'gluc', 'smoke', 'alco', 'active', 'age_years', 'bmi']]
                y = df['cardio']
                y_pred = model.predict(scaler.transform(X))
                
                acc = accuracy_score(y, y_pred)
                st.metric("Current Accuracy", f"{acc:.2%}")
                
                st.write("**Confusion Matrix**")
                cm = confusion_matrix(y, y_pred)
                fig, ax = plt.subplots(figsize=(6, 4))
                sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', ax=ax)
                st.pyplot(fig)
                
            except Exception as e:
                st.error("Could not run evaluation.")
    st.markdown("</div>", unsafe_allow_html=True)

def get_base64_image(image_path):
    with open(image_path, "rb") as img_file:
        return base64.b64encode(img_file.read()).decode()

def page_about():
    st.markdown("<div class='main-content'>", unsafe_allow_html=True)
    st.title("About") # Removed emoji
    
    # Logic to load image
    img_path = "my_photo.jpg"
    img_src = "https://cdn-icons-png.flaticon.com/512/4825/4825038.png"
    
    if os.path.exists(img_path):
        try:
            img_b64 = get_base64_image(img_path)
            img_src = f"data:image/jpeg;base64,{img_b64}"
        except:
             pass

    # HTML Card
    st.markdown(f"""
    <div class="profile-container">
        <img src="{img_src}" class="profile-img">
        <div class="profile-info">
            <h1>Smit Maru</h1>
            <h3>Darshan University | Sem-6 MLDL</h3>
            <div class="contact-badges">
                <span class="badge">📧 smitmaru1226@gmail.com</span>
                <span class="badge">📱 +91 87800 31119</span>
            </div>
            <br>
            <p style="color: #64748b; line-height: 1.6;">
                Passionate about leveraging Machine Learning to solve real-world healthcare challenges. 
                This project demonstrates the application of efficient algorithms for early disease detection.
            </p>
            <br>
            <a href="https://www.kaggle.com/sulianova/cardiovascular-disease-dataset" target="_blank" 
               style="background-color: #3b82f6; color: white; padding: 10px 25px; text-decoration: none; border-radius: 8px; font-weight: bold;">
               📂 View Dataset Source
            </a>
        </div>
    </div>
    """, unsafe_allow_html=True)

    st.markdown("</div>", unsafe_allow_html=True)

# --- Main Navigation ---
def main():
    
    # Custom Sidebar with Heart Monitor Logo
    st.sidebar.markdown("""
    <div style="text-align: center; margin-bottom: 20px;">
        <img src="https://img.icons8.com/color/96/000000/heart-monitor.png" width="80">
        <h2 style="color: white; margin: 10px 0;">Cardiolife</h2>
    </div>
    """, unsafe_allow_html=True)
    
    pages = {
        "🏠 Home": page_home,
        "📊 Analytics": page_data_insights,
        "🩺 Clinical Diagnostics": page_prediction,
        "🥗 Health Advice": page_advice,
        "📈 Model Evaluation": page_model_stats,
        "ℹ️ About": page_about
    }
    
    if 'navigation' not in st.session_state:
        st.session_state.navigation = "🏠 Home"
    
    selection = st.sidebar.radio("Go to", list(pages.keys()), key="navigation")
    
    pages[selection]()

if __name__ == "__main__":
    main()