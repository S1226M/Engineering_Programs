const express = require('express')
const bodyParser = require('body-parser')
const mongoose = require('mongoose')
const Student = require('./Student')
const conectionString = 'mongodb+srv://smitmaru1226:Smit%401226@cluster0.nr60d.mongodb.net/Collage_Smit_Sem_3'
mongoose.connect(conectionString).then(()=>{
    const app = express();
    app.use(bodyParser.urlencoded())

    //get all
    app.get('/student', async (req, res) => {
        const data = await Student.find();
        res.send(data)
    })

    //get by roll
    app.get('/student/:roll',async (req , res)=>{
        const data = await Student.findOne({roll:req.params.roll});
        res.send(data)
    })

    //get by name
    app.get('/student/:name', async (req , res)=>{
        const data = await Student.findOne({name:req.params.name})
        res.send(data)
    })

    //delete by roll
    app.delete('/student/:roll' , async (req,res)=>{
        const data = await Student.deleteOne({roll:req.params.roll})
        res.send(data)
    })

    //add
    app.post('/student' , async (req , res) => {
        const stu = new Student({...req.body})
        const ans = await stu.save()
        res.send(ans)
    })

    //update
    app.patch('/student/:roll' , async (req , res) =>{
        const stu = await Student.findOne({roll:req.params.roll})
        stu.name = req.body.name
        const ans = await stu.save()
        res.send(ans)
    })

    app.listen(4000,()=>{
        console.log("Serever is running on  port 4000")
    })
    console.log("Your server is connected with database")
})