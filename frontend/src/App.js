import 'bootstrap/dist/css/bootstrap.min.css'
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Home from "./pages/Home";
import Navbar from "./components/Navbar";
import SelectTaste from "./pages/SelectTaste";
import CreateGroup from "./pages/CreateGroup";
import Group from "./pages/Group";
import GroupID from "./pages/GroupID";


function App() {
  return (
          <Router>
              <Navbar />
              <Routes>
                  <Route path="/" element={<Home />}/>
                  <Route path="/taste" element={<SelectTaste />}/>
                  <Route path="/create" element={<CreateGroup />}/>
                  <Route path="/group" element={<Group />}/>
                  <Route path="/groupid" element={<GroupID />}/>
              </Routes>
          </Router>

  );
}

export default App;
