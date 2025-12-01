import streamlit as st
from datetime import date
st.title("chai Makker App")

if st.button("Make Chai"):
    st.success("Your chai has been Brewed")

addMasala = st.checkbox("Add Masala")
if addMasala:
    st.write("Masala added to your chia")

tea_type = st.radio("Pich yor chai base : ",["Milk","Water","Sugger"])
st.write(f"Selected Base {tea_type}")

flavour = st.selectbox("Chose flavour : ",["Adrak","Kesar"])
st.write(f"Selected Base {flavour}")

sugar = st.slider("Sugasr Level (spoon)",0,4,2)
st.write(f"Selected Sugar Level {sugar}")

cups = st.number_input("How many Cups ", min_value=1 , max_value=10, step=1)
st.write(f"Selected Sugar Level {cups}")

name = st.text_input("Enter Your name")
if name:
    st.write(f"Wellcome, {name} ! your chai is on the way")

dob = st.date_input("Select your date of birth")
st.write(f"yours date of birth is {dob}")

today = date.today()
dob = st.date_input("Select your date of birth",key="dob1",max_value=today,min_value = date(2006, 1, 1))
age = today.year - dob.year
st.write(f"Your age is = {age}")