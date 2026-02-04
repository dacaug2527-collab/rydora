import { useEffect, useState } from "react";
import axios from "axios";

function BookingHistory() {
  // 🔹 Read logged-in user from localStorage
  const user = JSON.parse(localStorage.getItem("user"));
  const driverId = user?.user_id;

  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    if (!driverId) {
      setError("Driver not logged in");
      setLoading(false);
      return;
    }

    axios
      .get(`http://localhost:8082/driver/bookinghistory/${driverId}`)
      .then((res) => {
        console.log(res.data);
        setBookings(res.data || []);
        setLoading(false);
      })
      .catch(() => {
        setError("Unable to fetch booking history");
        setLoading(false);
      });
  }, [driverId]);

  if (loading) {
    return (
      <div className="text-center mt-4">
        <div className="spinner-border text-primary"></div>
        <p className="mt-2">Loading booking history...</p>
      </div>
    );
  }

  if (error) {
    return <div className="alert alert-danger">{error}</div>;
  }

  return (
    <div>
      <h4 className="mb-4">Booking History</h4>

      {bookings.length === 0 ? (
        <div className="alert alert-warning">
          No booking history found.
        </div>
      ) : (
        <div className="table-responsive">
          <table className="table table-bordered table-hover">
            <thead className="table-dark">
              <tr>
                <th>#</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Pickup</th>
                <th>Drop</th>
              </tr>
            </thead>
            <tbody>
              {bookings.map((b, index) => (
                <tr key={b.bookingId ?? index}>
                  <td>{index + 1}</td>
                     <td>{b.firstName}</td>
                        <td>{b.lastName}</td>
                  <td>{b.startLocation}</td>
                  <td>{b.endLocation}</td>
                  
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default BookingHistory;
