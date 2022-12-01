import {useLocation} from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {useEffect, useState} from "react";
import axios from "axios";
import {
    Link,
    useNavigate
} from "react-router-dom";


function GroupID () {
    const {state} = useLocation();

    const { name, groupId } = state;
    console.log(groupId)
    const navigate = useNavigate()

return (
    <div className="container-fluid" style={{
        height: "90vh",
        backgroundImage: 'url("/assets/images/food_line_art_final.webp")',
        backgroundSize: "cover"
    }}>
        <div className="row h-100">
            <div className="col-sm-12 my-auto ">
                <div className="card bg-light justify-content-center px-5 py-5 w-50 text-center" style={{margin: "auto"}}>
                    <h1 style={{color: "#A03A3A"}}>Get Ready to Grub!<br></br></h1>
                    <h3>Here's your Group ID:</h3>
                    <div className="card bg-light justify-content-center px-3 py-5" >
                        <h2>{groupId}</h2>
                    </div>
                    <h3 className="align-content-center">
                        Share this with your friends to<br></br>
                        combine your tastes
                    </h3>
                    <Button variant="primary" type="button" onClick={() => {
                        navigate('/taste', {state: {"name": name, "groupId": groupId, isHost: false}})
                    }}>
                        <b>Select taste</b>
                    </Button>
                </div>
            </div>
        </div>


    </div>
);

}

export default GroupID;