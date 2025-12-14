import React from "react";
import Link from "next/link";

export default function Contact() {
  return (
    <div className="p-6 space-y-6 max-w-3xl mx-auto">

      {/* Page Title */}
      <h1 className="text-3xl font-bold">Contact Us</h1>

      <p className="text-gray-700 leading-relaxed">
        If you have any questions, feedback, or support requests, feel free to reach out
        to us. Our team is always happy to help you!
      </p>

      {/* Contact Form */}
      <div className="bg-white shadow-md rounded-2xl p-6 border">
        <h2 className="text-2xl font-semibold mb-4">Send Us a Message</h2>

        <form className="space-y-4">
          <div>
            <label className="block mb-1 font-semibold">Name</label>
            <input
              type="text"
              placeholder="Enter your name"
              className="w-full p-3 border rounded-xl focus:outline-none focus:ring focus:ring-blue-300"
            />
          </div>

          <div>
            <label className="block mb-1 font-semibold">Email</label>
            <input
              type="email"
              placeholder="Enter your email"
              className="w-full p-3 border rounded-xl focus:outline-none focus:ring focus:ring-blue-300"
            />
          </div>

          <div>
            <label className="block mb-1 font-semibold">Message</label>
            <textarea
              rows="4"
              placeholder="Write your message here..."
              className="w-full p-3 border rounded-xl focus:outline-none focus:ring focus:ring-blue-300"
            ></textarea>
          </div>

          <button
            type="submit"
            className="bg-blue-600 text-white px-6 py-3 rounded-xl hover:bg-blue-700 transition w-full"
          >
            Send Message
          </button>
        </form>
      </div>

      {/* Contact Info Cards */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div className="bg-white shadow-md rounded-2xl p-6 border">
          <h2 className="text-xl font-semibold mb-2">📧 Email Support</h2>
          <p className="text-gray-600 mb-2">support@yourapp.com</p>
          <p className="text-sm text-gray-500">We reply within 24 hours.</p>
        </div>

        <div className="bg-white shadow-md rounded-2xl p-6 border">
          <h2 className="text-xl font-semibold mb-2">📞 Phone</h2>
          <p className="text-gray-600 mb-2">+91 98765 43210</p>
          <p className="text-sm text-gray-500">Mon–Fri, 10am–6pm</p>
        </div>

        <div className="bg-white shadow-md rounded-2xl p-6 border md:col-span-2">
          <h2 className="text-xl font-semibold mb-2">📍 Address</h2>
          <p className="text-gray-600">123 HealthHub Street, Mumbai, India</p>
        </div>
      </div>

      <div>
        <Link href="/" className="text-blue-600 font-semibold hover:underline">
          ← Back to Dashboard
        </Link>
      </div>
    </div>
  );
}