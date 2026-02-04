function Sidebar({ active, setActive }) {
  return (
    <div>
      <h5 className="mb-4">Driver Component</h5>

      <div className="list-group">
        <button
          className={`list-group-item list-group-item-action ${active === "new" ? "active" : ""}`}
          onClick={() => setActive("new")}
        >
          New Request
        </button>

        <button
          className={`list-group-item list-group-item-action ${active === "history" ? "active" : ""}`}
          onClick={() => setActive("history")}
        >
          Booking History
        </button>

        <button
          className={`list-group-item list-group-item-action ${active === "document" ? "active" : ""}`}
          onClick={() => setActive("document")}
        >
          Update Document
        </button>

        <button
          className={`list-group-item list-group-item-action ${active === "availability" ? "active" : ""}`}
          onClick={() => setActive("availability")}
        >
          Availability / Not Available
        </button>
        
      </div>
    </div>
  );
}

export default Sidebar;
