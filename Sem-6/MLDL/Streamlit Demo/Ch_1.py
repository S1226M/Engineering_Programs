import streamlit as st
st.title("Hello chai App")
st.subheader("Welcome to your interective App")
st.text("Choose your fav. varity of chai")
st.write("Hellow")

# st.selectbox("Your Faviorate Color",["Select Faviorate Drink","Your Faviorate Food","Noon"])
a = st.selectbox("Your Fav Chai",["Masala Chai","Leamon Tea","Adrak chai","Kesar chai"])

st.write(f"You choose {a}, Excellent Choise")

st.success("your chai has been Brewed")