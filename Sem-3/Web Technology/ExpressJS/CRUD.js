const express = require('express')
const app = express()
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded())
const student = [
    {
        id: 23010101272,
        name: 'jainil',
        age: 18
    },
    {
        id: 23010101175,
        name: 'samarth',
        age: '20'
    }
]
app.get('/student', (req, res) => {
    res.send(student)
})

app.get('/student/:id', (req, res) => {
    const ans = student.find(stu => { return stu.id == req.params.id })
    res.send(ans)
})

app.post('/student', (req, res) => {
    student.push(req.body)
    res.send('student added')
})

app.patch('/student/:id', (req, res) => {
    const indexToUpdate = student.findIndex((stu) => { })
})
app.listen(3000, () => {
    console.log('server is running on port 3000')
})