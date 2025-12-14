import Link from "next/link";
import React from "react";

function AboutPage() {
  return (
    <div className="py-4">
      <h1 className="display-6 fw-bold mb-3">About our team</h1>
      <p className="text-secondary fs-5">
        We are a multidisciplinary team of designers, engineers, and product
        strategists focused on shipping reliable experiences for the web. Our
        work spans design systems, complex dashboards, and customer-facing sites
        that scale.
      </p>

      <div className="row g-3 mt-4">
        <div className="col-md-6">
          <div className="card h-100 shadow-sm">
            <div className="card-body">
              <h2 className="h5">Our approach</h2>
              <p className="text-secondary mb-0">
                We lead with discovery, mapping user goals to business outcomes.
                From there, we iterate quickly with accessible components,
                thorough QA, and clear documentation to keep stakeholders aligned.
              </p>
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <div className="card h-100 shadow-sm">
            <div className="card-body">
              <h2 className="h5">Tooling & stack</h2>
              <p className="text-secondary mb-0">
                Next.js, TypeScript, and Bootstrap for dependable UI; secure
                APIs with testing and CI/CD baked in; and observability to
                monitor performance after launch.
              </p>
            </div>
          </div>
        </div>
        <img
          src="https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=400&q=60"
          alt="Computer industry"
          className="img-fluid rounded-3 mt-3"
          style={{ maxWidth: "300px" }}
        />
      </div>

      <div className="d-flex gap-3 mt-4">
        <Link className="btn btn-primary" href="/contact">
          Meet the team
        </Link>
        <Link className="btn btn-outline-primary" href="/">
          Back to dashboard
        </Link>
      </div>
    </div>
  );
}

export default AboutPage;