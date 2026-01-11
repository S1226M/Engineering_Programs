import pandas as pd
import numpy as np
import pickle
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import accuracy_score, classification_report

# 1. Load Data
print("Loading Final_Data_Set.csv...")
df = pd.read_csv("Final_Data_Set.csv")

# 2. Preprocessing
# Ensure column order matches exactly what the UI expects
features = ['gender', 'ap_hi', 'ap_lo', 'cholesterol', 'gluc', 'smoke', 'alco', 'active', 'age_years', 'bmi']
target = 'cardio'

# Check for missing values
print(f"Original shape: {df.shape}")
df = df.dropna()
print(f"Shape after dropna: {df.shape}")

X = df[features]
y = df[target]

# 3. Scaling
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

# 4. Train/Test Split
X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.2, random_state=42)

# 5. Model Training (Random Forest)
print("Training Random Forest Classifier...")
# Increasing n_estimators for stability, max_depth to prevent extreme overfitting but allow complexity
model = RandomForestClassifier(n_estimators=200, max_depth=12, random_state=42)
model.fit(X_train, y_train)

# 6. Evaluation
y_pred = model.predict(X_test)
acc = accuracy_score(y_test, y_pred)
print(f"Model Accuracy: {acc:.4f}")
print("Classification Report:")
print(classification_report(y_test, y_pred))

# 7. Save Model and Scaler
print("Saving model.pkl and scaler.pkl...")
with open("model.pkl", "wb") as f:
    pickle.dump(model, f)
    
with open("scaler.pkl", "wb") as f:
    pickle.dump(scaler, f)

print("Training Complete. Files saved.")
