import React from "react";
import Link from "next/link";

function ContactPage() {
  return (
    <div className="py-4">
      <h1 className="display-6 fw-bold mb-3">Contact us</h1>
      <p className="text-secondary fs-5">
        Tell us about your project and we will respond within one business day.
        You can also reach us directly at contact@nextdemo.com.
      </p>

      <div className="row g-3 mt-4">
        <div className="col-md-6">
          <div className="card h-100 shadow-sm">
            <div className="card-body">
              <h2 className="h5">Send a message</h2>
              <form className="mt-3">
                <div className="mb-3">
                  <label className="form-label">Name</label>
                  <input type="text" className="form-control" placeholder="Your name" />
                </div>
                <div className="mb-3">
                  <label className="form-label">Email</label>
                  <input type="email" className="form-control" placeholder="you@example.com" />
                </div>
                <div className="mb-3">
                  <label className="form-label">Project details</label>
                  <textarea className="form-control" rows={4} placeholder="What are you building?" />
                </div>
                <button type="button" className="btn btn-primary">
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>

        <div className="col-md-6">
          <div className="card h-100 shadow-sm">
            <div className="card-body">
              <h2 className="h5">Visit us</h2>
              <p className="text-secondary mb-3">
                123 Demo Street, Suite 200
                <br />
                Pune, MH 411001
              </p>
              <p className="mb-1 fw-semibold">Hours</p>
              <p className="text-secondary mb-3">Mon–Fri, 9:00–18:00 IST</p>
              <p className="mb-1 fw-semibold">Phone</p>
              <p className="text-secondary mb-0">+91-98765-43210</p>
            </div>
          </div>
        </div>
      </div>

      <div className="mt-4">
        <Link className="text-primary text-decoration-none" href="/">
          Back to dashboard
        </Link>
      </div>
    </div>
  );
}

export default ContactPage;

