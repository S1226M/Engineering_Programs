const express = require('express')
const app = express();

app.get('/',(req,res)=>{
    res.send('Hello World');
}).listen(1234,()=>{
    console.log("server start at 1234")
});