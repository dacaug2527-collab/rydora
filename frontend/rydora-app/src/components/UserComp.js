// import React from 'react'

// const UserComp = () => {
//   return (
//     <div>UserComp</div>
//   )
// }

// export default UserComp                      

import React, { useState } from "react";

const UserComp = () => {
  const [showDrivers, setShowDrivers] = useState(false);

  const drivers = [
    { id: 1, name: "Ravi Kumar", rating: 4.5, price: 1200 },
    { id: 2, name: "Suresh Yadav", rating: 4.2, price: 1100 },
    { id: 3, name: "Amit Sharma", rating: 4.8, price: 1300 },
  ];

  return (
    <>
      {/* Navbar */}
      <nav className="navbar navbar-dark bg-primary">
        <div className="container-fluid">
          <span className="navbar-brand mb-0 h1">
            🚗 Driver Connect WebApp
          </span>
        </div>
      </nav>

      {/* Search Section */}
      <div className="container mt-4">
        <div className="row g-2 align-items-end">
          <div className="col-md-3">
            <label className="form-label">Source</label>
            <input type="text" className="form-control" placeholder="Enter source" />
          </div>

          <div className="col-md-3">
            <label className="form-label">Destination</label>
            <input type="text" className="form-control" placeholder="Enter destination" />
          </div>

          <div className="col-md-3">
            <label className="form-label">Date</label>
            <input type="date" className="form-control" />
          </div>

          <div className="col-md-3 d-grid">
            <button
              className="btn btn-success"
              onClick={() => setShowDrivers(true)}
            >
              Search
            </button>
          </div>
        </div>

        {/* Pricing Info */}
        <div className="card mt-4">
          <div className="card-body text-center">
            <h6>Initial Booking Price: ₹250</h6>
            <h6>Per Km: ₹3</h6>
            <h6>Extra Allowance: ₹600</h6>
          </div>
        </div>
      </div>

      {/* Driver Modal */}
      {showDrivers && (
        <div className="modal fade show d-block" tabIndex="-1">
          <div className="modal-dialog modal-dialog-centered">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Available Drivers</h5>
                <button
                  type="button"
                  className="btn-close"
                  onClick={() => setShowDrivers(false)}
                />
              </div>

              <div className="modal-body">
                {drivers.map((driver) => (
                  <div key={driver.id} className="card mb-2">
                    <div className="card-body">
                      <h6 className="card-title">{driver.name}</h6>
                      <p className="mb-1">⭐ Rating: {driver.rating}</p>
                      <p className="mb-2">Estimated Price: ₹{driver.price}</p>
                      <button className="btn btn-primary btn-sm">
                        Select Driver
                      </button>
                    </div>
                  </div>
                ))}
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
      )}

      {/* Modal Backdrop */}
      {showDrivers && <div className="modal-backdrop fade show"></div>}

      {/* Footer */}
      <footer className="bg-light text-center p-3 mt-4">
        © 2026 Driver Connect
      </footer>
    </>
  );
};

export default UserComp;