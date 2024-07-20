const child_process = require('child_process');

const ans = child_process.exec('dir',(err,stdo,stdin)=>{
    console.log(ans);
})

child_process.exec('abc.txt',(err,stdout,stdin)=>{
    console.log(stdout);
})