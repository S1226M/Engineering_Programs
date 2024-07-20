const fs = require('fs');

// const ans = fs.exists('D:\Engineering-Programs\Sem-3\Web Technology\Lab 17',(err)=>{
//     if(err){"file not found"}
//     console.log('found');
//  });

// const wr = fs.writeFile('xyz.txt', 'Hello World', (err,data)=>{
//     console.log("File Written");
// })

// const re = fs.readFile('D:\Engineering-Programs\Sem-3\Web Technology\Lab 17',(err)=>{
//     if(err){"file not exists"}
//     console.log()
// })

// const rename = fs.rename('xyz.txt','abc,txt',(err)=>{
//     if(err){throw err}
//     console.log("remaned")
// })

const del = fs.unlink('abc.txt',(err)=>{
    if(err){throw err}
    console.log("file was deleted")
})