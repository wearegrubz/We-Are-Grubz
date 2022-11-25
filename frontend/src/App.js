import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";
import SockJsClient from 'react-stomp';
import {useEffect} from "react";


function App() {

  useEffect(() => {
    let Sock = new SockJS('http://localhost:8080/ws');

  });


  return (
    <h1>hello</h1>
  );
}

export default App;
