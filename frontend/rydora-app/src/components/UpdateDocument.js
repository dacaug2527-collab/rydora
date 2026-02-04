import { useState } from "react";
import axios from "axios";

function UpdateDocument() {
  const [driverId, setDriverId] = useState("");
  const [formData, setFormData] = useState({
    driverLicense: "",
    panCard: "",
    accountNo: "",
    driverStatus: false
  });

  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);

  // 🔹 Handle input change
  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value
    });
  };

  // 🔹 Fetch existing driver info
  const fetchDriver = () => {
    if (!driverId) return;

    axios
      .get(`http://localhost:8082/driver/fetchUpdate/${driverId}`)
      .then((res) => {
        setFormData({
          driverLicense: res.data.driverLicense,
          panCard: res.data.panCard,
          accountNo: res.data.accountNo,
          driverStatus: res.data.driverStatus
        });
      })
      .catch(() => {
        setMessage("Driver not found");
      });
  };

  // 🔹 Update driver info
  const updateDriver = () => {
    setLoading(true);
    setMessage("");

    axios
      .put(`http://localhost:8082/driver/update/${driverId}`, formData)
      .then(() => {
        setMessage("Driver information updated successfully");
        setLoading(false);
      })
      .catch(() => {
        setMessage("Failed to update driver information");
        setLoading(false);
      });
  };

  return (
    <div className="container mt-4">
      <h4 className="mb-3">Update Driver Information</h4>

      {message && <div className="alert alert-info">{message}</div>}

      <div className="card p-4">
        {/* Driver ID */}
        <div className="mb-3">
          <label className="form-label">Driver ID</label>
          <input
            type="number"
            className="form-control"
            value={driverId}
            onChange={(e) => setDriverId(e.target.value)}
          />
          <button
            className="btn btn-secondary mt-2"
            onClick={fetchDriver}
          >
            Fetch Driver
          </button>
        </div>

        {/* License */}
        <div className="mb-3">
          <label className="form-label">Driver License</label>
          <input
            type="text"
            className="form-control"
            name="driverLicense"
            value={formData.driverLicense}
            onChange={handleChange}
          />
        </div>

        {/* PAN */}
        <div className="mb-3">
          <label className="form-label">PAN Card</label>
          <input
            type="text"
            className="form-control"
            name="panCard"
            value={formData.panCard}
            onChange={handleChange}
          />
        </div>

        {/* Account */}
        <div className="mb-3">
          <label className="form-label">Account Number</label>
          <input
            type="text"
            className="form-control"
            name="accountNo"
            value={formData.accountNo}
            onChange={handleChange}
          />
        </div>

        

        <button
          className="btn btn-primary"
          onClick={updateDriver}
          disabled={loading}
        >
          {loading ? "Updating..." : "Update Driver"}
        </button>
      </div>
    </div>
  );
}

export default UpdateDocument;
