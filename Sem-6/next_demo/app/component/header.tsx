import Link from "next/link";
import React from "react";

function Header() {
  return (
    <header className="bg-dark text-white py-3">
      <div className="container d-flex align-items-center justify-content-between">
        <h1 className="fs-4 mb-0">Next Demo</h1>
        <nav className="d-flex gap-3">
          <Link className="text-white text-decoration-none" href="/dashboard">
            Dashboard
          </Link>
          <Link className="text-white text-decoration-none" href="/home">
            Home
          </Link>
          <Link className="text-white text-decoration-none" href="/about">
            About
          </Link>
          <Link className="text-white text-decoration-none" href="/contact">
            Contact
          </Link>
          <Link className="text-white text-decoration-none" href="/users">
            Users
          </Link>
        </nav>
      </div>
    </header>
  );
}

export default Header;