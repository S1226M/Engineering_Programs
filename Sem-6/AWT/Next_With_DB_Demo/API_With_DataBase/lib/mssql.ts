import sql from "mssql";

const config: sql.config = {
  user: process.env.MSSQL_USER,
  password: process.env.MSSQL_PASSWORD,
  server: process.env.MSSQL_SERVER ?? "localhost",
  database: process.env.MSSQL_DATABASE,
  port: process.env.MSSQL_PORT ? Number(process.env.MSSQL_PORT) : 1433,
  options: {
    encrypt: false,
    trustServerCertificate: true,
    instanceName: process.env.MSSQL_INSTANCE,
  },
};

const globalForMssql = global as unknown as {
  mssqlPool?: sql.ConnectionPool;
};

export type StudentRecord = {
  id: number;
  Name: string;
  Number: string;
  gender: string;
};

export async function getMssqlPool() {
  if (globalForMssql.mssqlPool) {
    return globalForMssql.mssqlPool;
  }

  if (!config.user || !config.password || !config.database) {
    throw new Error("Missing MSSQL environment variables.");
  }

  const pool = await sql.connect(config);
  globalForMssql.mssqlPool = pool;
  return pool;
}

export async function fetchStudentsFromDb() {
  const pool = await getMssqlPool();

  const result = await pool.request().query<StudentRecord>(`
    SELECT
      Id as id,
      Name,
      Number,
      Gender as gender
    FROM Student
    ORDER BY Id DESC
  `);

  return result.recordset;
}

