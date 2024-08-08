const express = require('express');
const app = express();
app.get('/',(req,res)=>{
    res.send('Hello World');
});
app.get('/about',(req,res)=>{
    res.send('about')
})
app.get('/home',(req,res)=>{
    res.send('home')
})
app.get('/contact',(req,res)=>{
    res.send('contact')
})
app.listen(12345,()=>{
    console.log("server start at 12345")
})