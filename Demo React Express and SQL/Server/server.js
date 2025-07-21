const express = require('express');
const sql = require('mssql');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

// SQL Server Configuration
const config = {
  server: 'LAPTOP-H4KQ788T',       // Only machine name
  database: 'CSE_4A_ASP_NET',
  options: {
    trustServerCertificate: true,
    instanceName: 'SQLEXPRESS'     // 👈 add instanceName here
  },
  authentication: {
    type: 'ntlm',
    options: {
      domain: 'WORKGROUP',         // as per your `systeminfo`
      userName: 'smitm',           // as per `whoami` (`laptop-h4kq788t\smitm`)
      password: 'smit123'
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
