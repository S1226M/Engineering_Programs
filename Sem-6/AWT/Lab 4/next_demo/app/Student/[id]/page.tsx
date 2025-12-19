import React from "react";

export default async function StudentSelectByID({ params }: {
    params: Promise<{ id: string }>;
}) {
    const { id } = await params;
    const res = await fetch(
        `https://66f4f7b39aa4891f2a234f42.mockapi.io/hospital/${id}`
    );

    const student = await res.json();

    return (
        <div className="card">
            <div className="card-header">
                <h5 className="mb-0">{`Detail of ${student.Name}`}</h5>
            </div>
            <div className="card-body">
                <p>
                    <strong>ID:</strong> {student.id}
                </p>
                <p>
                    <strong>Name:</strong> {student.Name}
                </p>
                <p>
                    <strong>Number:</strong> {student.Number}
                </p>
                <p>
                    <strong>Gender:</strong> {student.gender}
                </p>
            </div>
        </div>
    );
}