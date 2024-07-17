const path = require('path');

filePath = 'D:\\Engineering-Programs\\Sem-3\\Web Technology\\Lab 17'

const ans1 = path.dirname(filePath);
console.log("Dirname :",ans1);

const ans2 = path.basename(filePath);
console.log("Base name :",ans2);

const ans3 = path.extname(filePath);
console.log("extname :",ans3);