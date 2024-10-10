const mongoose = require('mongoose')
const schema = new mongoose.Schema(
    {
        idType : String,
        number : Number,
        fullName : String,
        gender : String,
        symptoms : String,
        roomNumber : String,
        deposit : Number
    }
)
const Patient = mongoose.model('Patient',schema,'Patients');
module.exports=Patient