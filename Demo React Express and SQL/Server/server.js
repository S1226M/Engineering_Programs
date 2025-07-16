const express = require('express');
const sql = require('mssql');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

// SQL Server Configuration
const config = {
  server: 'LAPTOP-H4KQ788T\\SQLEXPRESS', // ← Your server from SSMS
  database: 'CSE_4A_ASP_NET',            // ← Your database name
  options: {
    trustServerCertificate: true
  },
  authentication: {
    type: 'ntlm',
    options: {
      domain: 'LAPTOP-H4KQ788T',
      userName: 'smitm',
      password: '' // Leave blank for Windows Auth if your backend user is already logged in
    }
  }
};

// SQL Route
sql.connect(config).then(pool => {
  console.log('✅ Connected to SQL Server');

  app.get('/users', async (req, res) => {
    try {
      const result = await pool.request().query('SELECT * FROM MST_User');
      res.json(result.recordset);
    } catch (err) {
      console.error('Query Error:', err);
      res.status(500).send(err.message);
    }
  });

  app.listen(8081, () => {
    console.log('🚀 Server running at http://localhost:8081');
  });

}).catch(err => {
  console.error('❌ SQL Connection Failed:', err);
});
