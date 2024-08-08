const express = require('express');
const fs = require('fs')
const data = fs.readFileSync('abc.txt');
const app = express();
app.get('/',(req,res)=>{
    res.send(data.toString());
}).listen(3456,()=>{
    console.log("server start at 3456")
})