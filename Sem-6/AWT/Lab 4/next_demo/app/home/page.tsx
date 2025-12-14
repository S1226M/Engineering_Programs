import Link from "next/link";
import React from "react";

function HomePage() {
  return (
    <div className="py-4">
      <section className="mb-5">
        <p className="text-primary fw-semibold mb-1">Welcome</p>
        <h1 className="display-5 fw-bold">Building digital experiences</h1>
        <p className="text-secondary fs-5">
          We help teams ship modern web apps faster with clear design systems,
          robust engineering, and dependable support.
        </p>
        <div className="d-flex gap-3">
          <Link className="btn btn-primary" href="/contact">
            Start a project
          </Link>
          <Link className="btn btn-outline-primary" href="/about">
            Learn more
          </Link>
        </div>
      </section>

      <section>
        <h2 className="h4 fw-semibold mb-3">What we do</h2>
        <div className="row g-3">
          <div className="col-md-4">
            <div className="card h-100 shadow-sm">
              <div className="card-body">
                <h3 className="h5">Product strategy</h3>
                <p className="text-secondary">
                  Discovery workshops, roadmaps, and validation to align your
                  product vision with user needs.
                </p>
              </div>
            </div>
          </div>
          <div className="col-md-4">
            <div className="card h-100 shadow-sm">
              <div className="card-body">
                <h3 className="h5">Design systems</h3>
                <p className="text-secondary">
                  Scalable UI kits, accessibility-first components, and brand
                  guidelines that keep teams in sync.
                </p>
              </div>
            </div>
          </div>
          <div className="col-md-4">
            <div className="card h-100 shadow-sm">
              <div className="card-body">
                <h3 className="h5">Full-stack delivery</h3>
                <p className="text-secondary">
                  Modern Next.js frontends backed by secure APIs, CI/CD, and cloud
                  infrastructure you can rely on.
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default HomePage;
