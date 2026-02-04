import { useState } from "react";
import Sidebar from "./Sidebar";
import NewRequest from "./NewRequest";
import BookingHistory from "./BookingHistory";
import UpdateDocument from "./UpdateDocument";
import Availability from "./Availabilty";

function DriverLayout() {
  const [active, setActive] = useState("new");

  const renderContent = () => {
    switch (active) {
      case "new":
        return <NewRequest />;
      case "history":
        return <BookingHistory />;
      case "document":
        return <UpdateDocument />;
      case "availability":
        return <Availability />;
      default:
        return <NewRequest />;
    }
  };

  return (
    <div className="container-fluid vh-100">
      <div className="row h-100">
        <div className="col-3 border-end">
          <Sidebar active={active} setActive={setActive} />
        </div>
        <div className="col-9 p-4">
          {renderContent()}
        </div>
      </div>
    </div>
  );
}

export default DriverLayout;
