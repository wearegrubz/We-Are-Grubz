// import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
} from "react-router-dom";
import Home from "./pages/Home";
import Navbar from "./components/Navbar";
import SelectTaste from "./pages/SelectTaste";


function App() {
  return (
    <Router>
        <Navbar />
        <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/taste" element={<SelectTaste />}/>
        </Routes>
    </Router>
  );
}

export default App;
