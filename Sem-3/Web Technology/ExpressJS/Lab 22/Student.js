const mongoose = require('mongoose')
const schema = new mongoose.Schema(
    {
        name :String,
        roll:Number,
        age:Number,
        gender:String
    }
)
const Student = mongoose.model('Student',schema,'Students');
module.exports=Student