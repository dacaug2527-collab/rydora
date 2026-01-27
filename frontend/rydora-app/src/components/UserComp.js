import React, { useState } from "react";

const UserComp = () => {
  const [showDrivers, setShowDrivers] = useState(false);
  const [drivers, setDrivers] = useState([]);
  const [loading, setLoading] = useState(false);

  // 🔗 Fetch drivers from backend
  const searchDrivers = async () => {
    try {
      setLoading(true);
      const response = await fetch("http://localhost:8082/drivers/available");
      const data = await response.json();
      console.log(data);
      setDrivers(data);
      setShowDrivers(true);
    } catch (error) {
      console.error("Error fetching drivers:", error);
      alert("Failed to load drivers");
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      {/* Navbar */}
      <nav className="navbar navbar-dark bg-primary">
        <div className="container-fluid">
          <span className="navbar-brand">🚗 Driver Connect WebApp</span>
        </div>
      </nav>

      {/* Search Section */}
      <div className="container mt-4">
        <div className="row g-2 align-items-end">
          <div className="col-md-3">
            <label className="form-label">Source</label>
            <input className="form-control" placeholder="Enter source" />
          </div>

          <div className="col-md-3">
            <label className="form-label">Destination</label>
            <input className="form-control" placeholder="Enter destination" />
          </div>

          <div className="col-md-3">
            <label className="form-label">Date</label>
            <input type="date" className="form-control" />
          </div>

          <div className="col-md-3 d-grid">
            <button className="btn btn-success" onClick={searchDrivers}>
              {loading ? "Searching..." : "Search"}
            </button>
          </div>
        </div>

        {/* Pricing Info */}
        <div className="card mt-4 text-center">
          <div className="card-body">
            <h6>Initial Booking Price: ₹250</h6>
            <h6>Per Km: ₹3</h6>+
            <h6>Extra Allowance: ₹600</h6>
          </div>
        </div>
      </div>

      {/* Driver Modal */}
      {showDrivers && (
        <>
          <div className="modal fade show d-block">
            <div className="modal-dialog modal-dialog-centered">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Available Drivers</h5>
                  <button
                    className="btn-close"
                    onClick={() => setShowDrivers(false)}
                  />
                </div>

                <div className="modal-body">
                  {drivers.length === 0 ? (
                    <p className="text-center">No drivers available</p>
                  ) : (
                    drivers.map(({ user }) => (
                      <div key={user.user_id} className="card mb-2">
                        <div className="card-body">
                          <h6>
                            {user.first_name} {user.last_name}
                          </h6>
                          <p>Email: {user.email}</p>
                          <p>Contact: {user.contact_no}</p>
                        </div>
                      </div>
                    ))
                  )}
                </div>

                <div className="modal-footer">
                  <button
                    className="btn btn-secondary"
                    onClick={() => setShowDrivers(false)}
                  >
                    Close
                  </button>
                </div>
              </div>
            </div>
          </div>

          <div className="modal-backdrop fade show"></div>
        </>
      )}

      {/* Footer */}
      <footer className="bg-light text-center p-3 mt-4">
        © 2026 Driver Connect
      </footer>
    </>
  );
};

export default UserComp;
