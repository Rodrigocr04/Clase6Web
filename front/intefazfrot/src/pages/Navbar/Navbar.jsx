import { NavLink } from "react-router-dom";
import "./Navbar.css"; // Importa el CSS específico para Navbar

function Navbar() {
  return (
    <nav className="navbar">
      <div className="nav-container">
<<<<<<< HEAD
        <NavLink to="/login" className="nav-link">Login</NavLink>
=======
>>>>>>> ba230306af08ef4a56b15810bafb6a49185a2c3e
        <NavLink to="/" className="nav-link">Inicio</NavLink>
        <NavLink to="/about" className="nav-link">About</NavLink>
        <NavLink to="/dashbord" className="nav-link">Dashbord</NavLink>
      </div>
    </nav>
  );
}

export default Navbar;