// import logo from './logo.svg';
import "./App.css";
import { Link, Routes, Route } from "react-router-dom";
import LoginComp from "./components/LoginComp";
import RegisterComp from "./components/RegisterComp";

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
      </Routes>
    </div>
  );
}

export default App;
