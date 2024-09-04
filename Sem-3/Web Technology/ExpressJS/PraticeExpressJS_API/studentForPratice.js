const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(bodyParser.urlencoded());

const student=[
    {
        roll : 101,
        name : 'smit',
        email : 'smitmaru1226@gmail.com',
    },
    {
        roll : 102,
        name : 'jainil',
        email : 'jainil1226@gmail.com',
    },
    {
        roll : 103,
        name : 'jenish',
        email : 'jenish1226@gmail.com',
    },
]

//  getAll
app.get('/student',(req,res)=>{
    res.send(student);
})

//getByRoll
app.get('/student/:roll',(req,res)=>{
    const stu = student.find((stu)=>{
        if(student.roll == req.params.roll){
            return true;
        }
    });
    res.send(stu)
})

//create
app.post('/student',(req,res)=>{
    student.push(req.body);
    res.send("Student is added")
})

// update
app.patch('/student/:roll',(req,res)=>{
    const update = student.findIndex((stu)=>{
        if(stu.roll == req.params.roll){
            return true;
        }
    })
    student[update] = req.body;
    res.send("student updated")
})

//delete
app.delete('/student/:roll',(req,res)=>{
    const deletedStudent = student.findIndex((stu)=>{
        if(stu.roll == req.params.roll){
            return true;
        }
    })
    student.splice(deletedStudent,1)
    res.send("student deleted")
})

//search
app.get('/student/search/:text',(req,res)=>{
    const ans = student.filter((stu)=>{
        if(stu.name.indexOf(req.params.text)>-1){
            return true;
        }
    })
    res.send(ans)
})

app.listen(4000,()=>{
    console.log("server started at port 4000")
})