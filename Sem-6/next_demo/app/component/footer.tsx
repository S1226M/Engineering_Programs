import React from "react";

function Footer() {
  const year = new Date().getFullYear();

  return (
    <footer className="bg-light border-top py-3 mt-auto">
      <div className="container d-flex justify-content-between align-items-center">
        <span className="text-muted">&copy; {year} Next Demo</span>
      </div>
    </footer>
  );
}

export default Footer;

