'use client';

import Link from 'next/link';
import React, { useState } from 'react';
import { USERS, User } from './data';

function Users() {
  const [users] = useState<User[]>(USERS);
  return (
    <div className="users-container">
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h1>Users Management</h1>
        <button className="btn btn-primary">Add New User</button>
      </div>

      <div className="card">
        <div className="card-header d-flex justify-content-between align-items-center">
          <h5 className="mb-0">All Users</h5>
          <div className="input-group" style={{ width: '300px' }}>
            <input 
              type="text" 
              className="form-control" 
              placeholder="Search users..." 
            />
            <button className="btn btn-outline-secondary" type="button">
              <i className="bi bi-search"></i> Search
            </button>
          </div>
        </div>
        <div className="card-body">
          <div className="table-responsive">
            <table className="table table-striped table-hover">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Role</th>
                  <th>Status</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {users.map((user) => (
                  <tr key={user.id}>
                    <td>{user.id}</td>
                    <td>{user.name}</td>
                    <td>{user.email}</td>
                    <td>
                      <span className={`badge ${
                        user.role === 'Admin' ? 'bg-danger' : 
                        user.role === 'Moderator' ? 'bg-warning' : 
                        'bg-secondary'
                      }`}>
                        {user.role}
                      </span>
                    </td>
                    <td>
                      <span className={`badge ${
                        user.status === 'Active' ? 'bg-success' : 'bg-secondary'
                      }`}>
                        {user.status}
                      </span>
                    </td>
                    <td>
                      <div className="d-flex">
                        <Link
                          href={`/users/${user.id}`}
                          className="btn btn-sm btn-outline-secondary me-2"
                        >
                          View
                        </Link>
                        <button className="btn btn-sm btn-outline-primary me-2">Edit</button>
                        <button className="btn btn-sm btn-outline-danger">Delete</button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          
          <nav aria-label="Page navigation">
            <ul className="pagination justify-content-center">
              <li className="page-item disabled">
                <a className="page-link" href="#" tabIndex={-1}>Previous</a>
              </li>
              <li className="page-item active">
                <a className="page-link" href="#">1</a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">2</a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">3</a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">Next</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  );
}

export default Users;

