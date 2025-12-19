import Link from "next/link";
import { notFound } from "next/navigation";
import { USERS, User } from "../data";

export function generateStaticParams() {
    return USERS.map((user) => ({
        id: String(user.id),
    }));
}

export default function UserDetail({ params }: { params: { id: string } }) {
    const userId = parseInt(params.id, 10);
    console.log("User ID:", userId);

    return (
        <div className="row justify-content-center">
            <div className="col-lg-8 col-xl-7">
                <div className="card shadow-sm">
                    <div className="card-header d-flex justify-content-between align-items-center">
                        <h5 className="mb-0">User Details</h5>
                        <Link href="/users" className="btn btn-sm btn-outline-secondary">
                            Back
                        </Link>
                    </div>
                    <div className="card-body">
                        <dl className="row mb-0">
                            <dt className="col-sm-3">ID</dt>
                            <dd className="col-sm-9">{user.id}</dd>

                            <dt className="col-sm-3">Name</dt>
                            <dd className="col-sm-9">{user.name}</dd>

                            <dt className="col-sm-3">Email</dt>
                            <dd className="col-sm-9">{user.email}</dd>

                            <dt className="col-sm-3">Role</dt>
                            <dd className="col-sm-9">{user.role}</dd>

                            <dt className="col-sm-3">Status</dt>
                            <dd className="col-sm-9">{user.status}</dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
    );
}