//Router:	Envuelve la aplicación y gestiona la navegación.
//Routes:	Agrupa múltiples rutas y muestra solo la primera coincidencia.
//Route:	Define una URL específica y qué componente renderizar.

//Instala lo siguiente
//npm install sockjs-client stompjs


import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./pages/Navbar/Navbar";
import Home from "./pages/mainPages/Home";
import About from "./pages/mainPages/About";
import Dashbord from "./pages/mainPages/Dashbord";
import Default from "./pages/mainPages/Default";
<<<<<<< HEAD
import Login from "./pages/mainPages/Login";
=======
>>>>>>> ba230306af08ef4a56b15810bafb6a49185a2c3e


function App() {
  return (
    <Router>
      <div className="app">
        {/* Barra de navegación */}
        <Navbar />
        {/* Contenido de la página */}
        <div className="content">
          <Routes>
<<<<<<< HEAD
            <Route path="/login" element={<Login />} />
=======
>>>>>>> ba230306af08ef4a56b15810bafb6a49185a2c3e
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/dashbord" element={<Dashbord />} />
            <Route path="*" element={<Default />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
