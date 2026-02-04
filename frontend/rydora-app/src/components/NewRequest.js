import React, { useEffect, useState } from "react";
import axios from "axios";

function NewRequest() {
  const [requests, setRequests] = useState([]);

  // Load new booking requests automatically
  useEffect(() => {
    loadNewRequests();
  }, []);

  const loadNewRequests = () => {
    axios
      .get("http://localhost:8082/driver/newrequest")
      .then((res) => {
        setRequests(res.data);
        console.log(res.data);
      })
      .catch((err) => {
        console.error("Error loading requests", err);
      });
  };

  // 🔥 ACCEPT ACTION
  const acceptBooking = (bookingId) => {
    axios
      .put(`http://localhost:8082/driver/accept/${bookingId}`)
      .then((res) => {
        alert("Booking Accepted ✅");
        console.log(res);

        // Remove accepted booking from UI
        setRequests(
          requests.filter((req) => req.bookingId !== bookingId)
        );
      })
      .catch((err) => {
        console.error("Accept failed", err);
        alert("Failed to accept booking ❌");
      });
  };

  return (
    <div>
      <h2>New Booking Requests</h2>

      <table className="table table-bordered">
        <thead>
          <tr>
            <th>#</th>
            <th>Customer</th>
            <th>Pickup</th>
            <th>Drop</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {requests.map((req, index) => (
            <tr key={req.bookingId}>
              <td>{index + 1}</td>
              <td>{req.firstName}</td>
              <td>{req.startLocation}</td>
              <td>{req.endLocation}</td>
              <td>{req.startDate}</td>
              <td>{req.endDate}</td>
              <td>
                <button
                  className="btn btn-success btn-sm"
                  onClick={() => acceptBooking(req.bookingId)}
                >
                  Accept
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default NewRequest;
