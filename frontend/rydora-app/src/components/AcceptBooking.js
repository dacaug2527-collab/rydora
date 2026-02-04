import React, { useEffect, useState } from "react";
import axios from "axios";

function AcceptBooking() {
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);

  // Fetch new booking requests when component loads
  useEffect(() => {
    fetchNewRequests();
  }, []);

  const fetchNewRequests = () => {
    axios
      .get("http://localhost:8082/driver/newrequest")
      .then((response) => {
        setBookings(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching bookings:", error);
        setLoading(false);
      });
  };

  // Accept booking
  const acceptBooking = (bookingId) => {
    axios
      .put(`http://localhost:8082/driver/accept/${bookingId}`)
      .then(() => {
        alert("Booking accepted successfully ✅");

        // Remove accepted booking from UI
        setBookings(
          bookings.filter((booking) => booking.bookingId !== bookingId)
        );
      })
      .catch((error) => {
        console.error("Error accepting booking:", error);
        alert("Failed to accept booking ❌");
      });
  };

  if (loading) {
    return <p>Loading booking requests...</p>;
  }

  return (
    <div style={{ padding: "20px" }}>
      <h2>New Booking Requests</h2>

      {bookings.length === 0 ? (
        <p>No new booking requests 🚕</p>
      ) : (
        <table border="1" cellPadding="10" cellSpacing="0">
          <thead>
            <tr>
              <th>Booking ID</th>
              <th>Pickup Location</th>
              <th>Drop Location</th>
              <th>Amount</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {bookings.map((booking) => (
              <tr key={booking.bookingId}>
                <td>{booking.bookingId}</td>
                <td>{booking.pickupLocation}</td>
                <td>{booking.dropLocation}</td>
                <td>₹{booking.amount}</td>
                <td>
                  <button onClick={() => acceptBooking(booking.bookingId)}>
                    Accept
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default AcceptBooking;
