import './Home.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {
    BrowserRouter as Router,
    Routes,
    Route,
    Link
} from "react-router-dom";
import Navbar from "../components/Navbar";


function Home() {
    return (

        <>
            <Navbar />
            <div className="container h-100 d-flex justify-content-center">
                    <div className="col-md-8">
                        <h1 className="text-center mx-auto my-auto align-items-center">
                            Dining with friends should be simple.
                        </h1>
                    </div>
                {/*<div className="d-flex align-items-center">*/}
                {/*    <h1>*/}
                {/*        Dining with friends should be simple.*/}
                {/*    </h1>*/}
                {/*</div>*/}
            </div>
        </>

    );
}

export default Home;
