const mongoose = require('mongoose')
const schema = new mongoose.Schema(
    {
        CustomerId : Int,
        CustomerName : String,
        OredrCatgory : String,
        OredrName : String,
        TableNO : int,
        PhoneNo : int
    }
)
const Customer = mongoose.model('Customer',schema,'Customers');
module.exports=Customer