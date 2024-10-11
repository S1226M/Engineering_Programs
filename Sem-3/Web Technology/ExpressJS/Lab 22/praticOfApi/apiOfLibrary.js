const mongoose = require('mongoose')
const express = require('express')
const library = require('./library')
const bodyParser = require('body-parser')

const conectionString = "mongodb String"
mongoose.connect(conectionString).then(()=>{
    const app = express();
    app.use(bodyParser.JSON())

    app.get('/library' , async (req , res) => {
        const b = await library.find();
        res.send(b);
    })

    app.get('/library/:id' , async (req ,res)=>{
        const bi = await library.findOne({id : req.params.is});
        res.send(bi);
    })

    app.delete('/library/:id' , async (req, res)=>{
        const bd = await library.deleteOne({id : req.params.is});
        res.send(bd)
    })

    app.post('/library' , async (req,res)=>{
        const bn = new library({...req.body})
        const sb = await library.save()
        res.send(sb)
    })

    app.put('/library/:id' , async (req, res)=>{
        const b = await library.findOneAndUpdate(
            {id : req.body},
            {...req.body},
        )
        res.send(b)
    })

    app.lition(3000,()=>{
        console.log('server start at port 3000')
    })
    console.log('you are connected with database')
})