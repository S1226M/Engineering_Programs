const express = require('express')
const bodyParser = require('body-parser')
const mongoose = require('mongoose')
const Customer = require('./Customer')
const conectionString = 'mongodb+srv://smitmaru1226:Smit@1226@cluster0.nr60d.mongodb.net/CoffeeShop'
mongoose.connect(conectionString).then(()=>{
    const app = express();
    app.use(bodyParser.urlencoded())

    //get all
    app.get('/customer', async (req,res) => {
        const data = await Customer.find();
        res.send(data)
    })

    //get by cId
    app.get('/customer/:id' , async (req,res) => {
        const data = await Customer.findOne({CustomerId : req.params.id})
        res.send(data)
    })

    //create
    app.post('/custoemer', async(req,res)=>{
        const cu = new Customer({...req.body})
        const ans = await cu.save()
        res.send(ans)
    })

    //delete
    app.delete('/customer/:id' , async (req,res) =>{
        const data = await Customer.deleteOne({CustomerId : req.params.id})
        res.send(data);
    })

    // update
    app.patch('/customer/:id' , async (req,res)=>{
        const data = await Customer.findOne({CustomerId : req.params.id})
        data.name = req.body.name
        const ans = await data.save()
        res.send(ans)
    })

    // //search
    // app.get('/customer/search/:text' , async (req,res)=>{
    //     const customers = await Customer.getFilter({ name: { $regex: searchText, $options: 'i' } });
    // })
})