import { useEffect, useState } from "react";
import axios from "axios";

function Availability() {
  const user = JSON.parse(localStorage.getItem("user"));
  const userId = user?.user_id;

  const [driverId, setDriverId] = useState(null);
  const [available, setAvailable] = useState(false);
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState("");

  // 🔹 Fetch driverId using userId
  useEffect(() => {
    if (!userId) return;

    axios
      .get(`http://localhost:8082/driver/by-user/${userId}`)
      .then((res) => {
        setDriverId(res.data);
      })
      .catch(() => {
        setMessage("Unable to fetch driver details");
      });
  }, [userId]);

  if (!userId) {
    return <div className="alert alert-danger">Driver not logged in</div>;
  }

  if (!driverId) {
    return <div className="alert alert-warning">Loading driver info...</div>;
  }

  const setAvailableStatus = (status) => {
    setLoading(true);
    setMessage("");

    const url = status
      ? `http://localhost:8082/driver/available/${driverId}`
      : `http://localhost:8082/driver/notavailable/${driverId}`;

    axios
      .put(url)
      .then((res) => {
        setAvailable(status);
        setMessage(`Driver is now ${res.data}`);
        setLoading(false);
      })
      .catch(() => {
        setMessage("Failed to update availability");
        setLoading(false);
      });
  };

  return (
    <div>
      <h4 className="mb-4">Driver Availability</h4>

      {message && <div className="alert alert-info">{message}</div>}

      <div className="card p-4">
        <h5 className="mb-3">
          Current Status:
          <span
            className={`ms-2 badge ${
              available ? "bg-success" : "bg-danger"
            }`}
          >
            {available ? "AVAILABLE" : "NOT AVAILABLE"}
          </span>
        </h5>

        <div className="mt-3">
          <button
            className="btn btn-success me-3"
            disabled={available || loading}
            onClick={() => setAvailableStatus(true)}
          >
            Set Available
          </button>

          <button
            className="btn btn-danger"
            disabled={!available || loading}
            onClick={() => setAvailableStatus(false)}
          >
            Set Not Available
          </button>
        </div>
      </div>
    </div>
  );
}

export default Availability;
