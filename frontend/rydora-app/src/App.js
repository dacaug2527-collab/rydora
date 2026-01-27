// import logo from './logo.svg';
import "./App.css";
import { Link, Routes, Route } from "react-router-dom";
import LoginComp from "./components/LoginComp";
import RegisterComp from "./components/RegisterComp";
import UserComp from "./components/UserComp";
import DriverComp from "./components/DriverComp";

function App() {
  return (
    <div className="App">
      
      <ul className='nav navbar'>
          <li className='nav-item'>
            <Link className='nav-link' to="/login">LOGIN</Link> 
          </li>
          <li className='nav-item'>
            <Link className='nav-link' to="/register">REGISTER</Link> 
          </li>
       </ul> 

       

      <Routes>
        <Route path="/login" element={<LoginComp />} />
        <Route path="/register" element={<RegisterComp />} />
         <Route path="/userComp" element={<UserComp />} />
         <Route path="/driver" element={<DriverComp />} />
      </Routes>
    </div>
  );
}

export default App;
