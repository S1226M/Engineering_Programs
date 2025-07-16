import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function Home() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8081/users')
      .then(res => {
        setUsers(res.data);
      })
      .catch(err => {
        console.error('Error fetching users:', err);
      });
  }, []);

  return (
    <div>
      <h2>Users List</h2>
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>UserID</th>
            <th>UserName</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>IsActive</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user, idx) => (
            <tr key={idx}>
              <td>{user.UserID}</td>
              <td>{user.UserName}</td>
              <td>{user.Email}</td>
              <td>{user.Mobile}</td>
              <td>{user.IsActive ? 'Yes' : 'No'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
