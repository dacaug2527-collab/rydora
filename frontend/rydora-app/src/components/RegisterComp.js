import React, { useState } from "react";
import {  useNavigate } from "react-router-dom";


const RegisterComp = () => {
  const navigate= useNavigate();
  const [formData, setFormData] = useState({
    user_name: "",
    password: "",
    email: "",
    contact_no: "",
    first_name: "",
    last_name: "",
    aadhar: "",
    role_id: 2
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
  e.preventDefault();

  try {
    const res = await fetch("http://localhost:8081/users/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData)
    });

    if (!res.ok) throw new Error("Registration failed");

    alert("User added successfully");
    navigate("/login");
  } catch (err) {
    console.error(err);
  }
};


  return (
    <div>
      <h2>Add User</h2>

      <form onSubmit={handleSubmit}>
        <input name="user_name" placeholder="Username" onChange={handleChange} value={formData.user_name} required />
        <br />

        <input type="password" name="password" placeholder="Password" onChange={handleChange} value={formData.password} required />
        <br />

        <input name="email" placeholder="Email" onChange={handleChange} value={formData.email} />
        <br />

        <input name="contact_no" placeholder="Contact No" onChange={handleChange} value={formData.contact_no} />
        <br />

        <input name="first_name" placeholder="First Name" onChange={handleChange} value={formData.first_name} />
        <br />

        <input name="last_name" placeholder="Last Name" onChange={handleChange} value={formData.last_name} />
        <br />

        <input name="aadhar" placeholder="Aadhaar Number" onChange={handleChange} value={formData.aadhar} />
        <br />

        <select name="role_id" onChange={handleChange} value={formData.role_id}>
          <option value={1}>Admin</option>
          <option value={2}>User</option>
          <option value={3}>Driver</option>
        </select>
        <br /><br />

        <button type="submit">Save User</button>
      </form>
    </div>
  );
};

export default RegisterComp;