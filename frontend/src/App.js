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
import CreateGroup from "./pages/CreateGroup";
import SignUp from "./pages/SignUp";
import SignIn from "./pages/SignIn";
import Group from "./pages/Group";
/*
import Parse from 'parse/react-native.js';
import AsyncStorage from '@react-native-async-storage/async-storage';

Parse.setAsyncStorage(AsyncStorage);

const PARSE_APPLICATION_ID = process.env.REACT_APP_PARSE_APPLICATION_ID;
const PARSE_HOST_URL = 'https://parseapi.back4app.com/';
const PARSE_JAVASCRIPT_ID = process.env.REACT_APP_PARSE_JAVASCRIPT_ID;
Parse.initialize(PARSE_APPLICATION_ID, PARSE_JAVASCRIPT_ID);
Parse.serverURL = PARSE_HOST_URL;

 */

function App() {
  return (
          <Router>
              <Navbar />
              <Routes>
                  <Route path="/" element={<Home />}/>
                  <Route path="/taste" element={<SelectTaste />}/>
                  <Route path="/create" element={<CreateGroup />}/>
                  <Route path="/signup" element={<SignUp />}/>
                  <Route path="/signin" element={<SignIn />}/>
                  <Route path="/group" element={<Group />}/>
              </Routes>
          </Router>

  );
}

export default App;
