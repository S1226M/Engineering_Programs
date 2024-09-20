import React, { useState } from "react";

function Crud() {
  const [student, setStudent] = useState([]);
  const [data, setData] = useState({ name: "", sem: "" });
  const [isEdit, setIsEdit] = useState(false); 
  const [editIndex, setEditIndex] = useState(null)

  const handleAddOrEdit = (e) => {
    e.preventDefault();
    if (isEdit) {
      const updatedStudents = student.map((stu, idx) =>
        idx === editIndex ? data : stu
      );
      setStudent(updatedStudents);
      setIsEdit(false); 
    } else {
      setStudent([data, ...student]);
    }
    setData({ name: "", sem: "" });
    setEditIndex(null); 
  };

  const handleEdit = (idx) => {
    setData(student[idx]);
    setIsEdit(true); 
    setEditIndex(idx);
  };

  const Stu = () => {
    return (
      <>
        <table>
          <thead>
            <tr>
              <td>Name</td>&nbsp;
              <td>Semester</td>&nbsp;
              <td>Actions</td>&nbsp;
            </tr>
          </thead>
          <tbody>
            {student.map((e, idx) => (
              <tr key={idx}>
                <td>Name : {e.name}</td>
                <td>Sem : {e.sem}</td>
                <td>
                  <button onClick={() => handleEdit(idx)}>Edit</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </>
    );
  };

  return (
    <>
      <input type="text"placeholder="Enter Name"value={data.name}onChange={(e) => {
        setData({ ...data, name: e.target.value })
    }}
      /><input type="text"placeholder="Enter Semester"value={data.sem} onChange={
        (e) => setData({ ...data, sem: e.target.value })}
      />
      <button onClick={handleAddOrEdit}>
        {isEdit ? "Edit" : "Add"}
      </button>
      <div>
        <Stu />
      </div>
    </>
  );
}

export default Crud;