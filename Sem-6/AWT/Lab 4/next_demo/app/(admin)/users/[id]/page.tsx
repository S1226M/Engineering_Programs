import Link from "next/link";
import { notFound } from "next/navigation";
import { USERS } from "../data";

// Pre-generate all user detail pages for the known IDs
export function generateStaticParams() {
  return USERS.map((user) => ({
    id: String(user.id),
  }));
}

export default async function UserDetail({ params }: { params: Promise<{ id: string }> }) {
  const { id } = await params;
  const userId = parseInt(id, 10);

  const user = USERS.find((u) => u.id === userId);

  if (!user) {
    notFound();
  }

  return (
    <div className="row justify-content-center">
      <div className="col-lg-8 col-xl-7">
        <div className="card shadow-sm">
          <div className="card-header d-flex justify-content-between align-items-center">
            <h5 className="mb-0">User Details</h5>
            {/* `(admin)` is a grouping segment, so URL path is just `/users` */}
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