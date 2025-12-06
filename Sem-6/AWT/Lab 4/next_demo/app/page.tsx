import Image from "next/image";
import Link from "next/link";

export default function Home() {
  return (
    <>
      <div className="d-flex gap-3 align-items-center py-3">
        <Link href="/home" className="text-decoration-none text-primary fw-semibold">
          Home
        </Link>
        <span className="text-secondary">|</span>
        <Link href="/about" className="text-decoration-none text-primary fw-semibold">
          About
        </Link>
      </div>
    </>

  );
}
