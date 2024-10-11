const mongoose = require('mongoose')
const schema = new mongoose.Schema(
    {
        // ....
    }
)
const library = mongoose.module('library',shema,'library')
module.exports = library;