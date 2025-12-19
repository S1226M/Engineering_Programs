import React from "react";
import { fetchStudentsFromDb, type StudentRecord } from "../../lib/mssql";

export const dynamic = "force-dynamic";

export default async function StudentMSSQL() {
  let students: StudentRecord[] = [];
  let error: string | null = null;

  try {
    students = await fetchStudentsFromDb();
  } catch (err) {
    error =
      err instanceof Error
        ? err.message
        : "Could not load students from the database.";
  }

  return (
    <div className="card">
      <div className="card-header d-flex justify-content-between align-items-center">
        <h5 className="mb-0">Students (MSSQL)</h5>
        <span className="text-muted small">Data queried directly from SQL Server</span>
      </div>
      <div className="card-body">
        {error ? (
          <div className="alert alert-danger mb-0">{error}</div>
        ) : (
          <div className="table-responsive">
            <table className="table table-striped table-hover">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Number</th>
                  <th>Gender</th>
                </tr>
              </thead>
              <tbody>
                {students.length === 0 ? (
                  <tr>
                    <td colSpan={4} className="text-center">
                      No students found.
                    </td>
                  </tr>
                ) : (
                  students.map((student) => (
                    <tr key={student.id}>
                      <td>{student.id}</td>
                      <td>{student.Name}</td>
                      <td>{student.Number}</td>
                      <td>{student.gender}</td>
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}
