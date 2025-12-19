import Link from 'next/link';
import React from 'react'

function StudentPage() {
    const data = fetch("https://66f4f7b39aa4891f2a234f42.mockapi.io/hospital").then(res => res.json());
    return (
        <>
            <div className="card">
                <div className="card-header d-flex justify-content-between align-items-center">
                    <h5 className="mb-0">Student Page</h5>
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
                                    <th>id</th>
                                    <th>Name</th>
                                    <th>Number</th>
                                    <th>gender</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {data.then((data) => (
                                    data.map((item: any) => (
                                        <tr key={item.id}>
                                            <td>{item.id}</td>
                                            <td>{item.Name}</td>
                                            <td>{item.Number}</td>
                                            <td>{item.gender}</td>
                                            <td>
                                                <div className="d-flex">
                                                    <Link
                                                        href={`/Student/${item.id}`}
                                                        className="btn btn-sm btn-outline-secondary me-2"
                                                    >
                                                        View
                                                    </Link>
                                                    <button className="btn btn-sm btn-outline-primary me-2">Edit</button>
                                                    <button className="btn btn-sm btn-outline-danger">Delete</button>
                                                </div>
                                            </td>
                                        </tr>
                                    ))
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
        </>
    )
}

export default StudentPage
