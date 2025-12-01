import streamlit as st
import pandas as pd

st.title("Chai Sales Dashboard")

file = st.file_uploader("Uploade your CSV File",type=["csv"])

if file:
    df = pd.read_csv(file)
    st.subheader("Data Preview")
    st.dataframe(df)
    st.write(df.describe())

if file:
    cities = df["city"].unique()
    selected_city = st.selectbox("Filter by cities", cities)
    filter_data = df[df["city"] == selected_city]
    st.dataframe(filter_data)
