'use client';

import React from 'react';

function Dashboard() {
  return (
    <div className="dashboard-container">
      <h1 className="mb-4">Admin Dashboard</h1>
      
      <div className="row g-4 mb-4">
        <div className="col-md-3">
          <div className="card text-white bg-primary">
            <div className="card-body">
              <h5 className="card-title">Total Users</h5>
              <h2 className="card-text">1,234</h2>
              <small>+12% from last month</small>
            </div>
          </div>
        </div>
        
        <div className="col-md-3">
          <div className="card text-white bg-success">
            <div className="card-body">
              <h5 className="card-title">Active Sessions</h5>
              <h2 className="card-text">456</h2>
              <small>Currently online</small>
            </div>
          </div>
        </div>
        
        <div className="col-md-3">
          <div className="card text-white bg-warning">
            <div className="card-body">
              <h5 className="card-title">Pending Tasks</h5>
              <h2 className="card-text">89</h2>
              <small>Require attention</small>
            </div>
          </div>
        </div>
        
        <div className="col-md-3">
          <div className="card text-white bg-info">
            <div className="card-body">
              <h5 className="card-title">Revenue</h5>
              <h2 className="card-text">$12,345</h2>
              <small>This month</small>
            </div>
          </div>
        </div>
      </div>

      <div className="row">
        <div className="col-md-8">
          <div className="card">
            <div className="card-header">
              <h5 className="mb-0">Recent Activity</h5>
            </div>
            <div className="card-body">
              <ul className="list-group list-group-flush">
                <li className="list-group-item d-flex justify-content-between align-items-center">
                  New user registered
                  <span className="badge bg-primary rounded-pill">2 mins ago</span>
                </li>
                <li className="list-group-item d-flex justify-content-between align-items-center">
                  Profile updated
                  <span className="badge bg-primary rounded-pill">15 mins ago</span>
                </li>
                <li className="list-group-item d-flex justify-content-between align-items-center">
                  System backup completed
                  <span className="badge bg-primary rounded-pill">1 hour ago</span>
                </li>
                <li className="list-group-item d-flex justify-content-between align-items-center">
                  Security alert resolved
                  <span className="badge bg-primary rounded-pill">3 hours ago</span>
                </li>
              </ul>
            </div>
          </div>
        </div>
        
        <div className="col-md-4">
          <div className="card">
            <div className="card-header">
              <h5 className="mb-0">Quick Actions</h5>
            </div>
            <div className="card-body">
              <div className="d-grid gap-2">
                <button className="btn btn-primary">Add New User</button>
                <button className="btn btn-secondary">View Reports</button>
                <button className="btn btn-success">Export Data</button>
                <button className="btn btn-warning">Settings</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;

