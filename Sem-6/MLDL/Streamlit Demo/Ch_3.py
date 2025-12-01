import streamlit as st
st.title("Chai Teaste Poll")

col1 , col2 = st.columns(2)
with col1:
    st.header("Masala Chai")
    st.image("https://media.istockphoto.com/id/1482828620/photo/clay-tea-cup-being-hold-in-the-hand.jpg?s=612x612&w=0&k=20&c=zULj4iZBUdV4TjzeYQLBr3QGD_1lPRuGtnD1i57p-A8=",width=200)
    vot1 = st.button("Vote masala")
with col2:
    st.header("Adrak Chai")
    st.image("https://media.istockphoto.com/id/1482828620/photo/clay-tea-cup-being-hold-in-the-hand.jpg?s=612x612&w=0&k=20&c=zULj4iZBUdV4TjzeYQLBr3QGD_1lPRuGtnD1i57p-A8=",width=200)
    vot2 = st.button("Vote Adralk chai")
if vot1:
    st.success("Thanks for MAsala Chai")
elif vot2:
    st.success("Thanks for Adrak Chai")

name = st.sidebar.text_input("Enter Your name ")
tea = st.sidebar.selectbox("Choose ypur chai : ",["Masala","Adrak","Kesar"])
st.write(f"Wellcome {name} and your {tea} is getting ready.")

with st.expander("Show Chai making instructions"):
    st.write("""
    1.Boil water with tea
    2.Boil water with tea
    2.Boil water with tea
    2.Boil water with tea
    """)

st.markdown("### welcome to chai App")
st.markdown('>Blockquote')
st.markdown('>Blockquote')