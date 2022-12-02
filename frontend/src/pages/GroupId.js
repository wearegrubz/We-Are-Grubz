import {useLocation} from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {useEffect, useState} from "react";
import axios from "axios";
import {
    Link,
    useNavigate
} from "react-router-dom";


function GroupId () {
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
                <Form>
                    <div className="col-sm-12 card justify-content-center mx-auto w-50">
                        <div className="mx-5 my-5">
                            <h1>Get Ready to Grub!</h1>
                            <br/>
                            <h3 style={{fontFamily: "Hand_Of_Sean", color:"#A03A3A"}}>Here's your Group ID:</h3>
                            <br/>
                            <div className="card bg-light justify-content-center px-4 py-4" >
                                <h1 style={{color: "#202020", fontFamily: "scandia-web", textAlign: "center"}}>{groupId}</h1>
                            </div>
                            <br/>
                            <h4 style={{textAlign: "center"}}>Share this with your friends<br/>to combine your tastes.</h4>
                            <br/>
                            <div className="row align-content-center">
                                <Button id="btn" variant="danger" type="button" size="lg" onClick={() => {
                                    navigate('/taste', {state: {"name": name, "groupId": groupId, isHost: false}})
                                }}>
                                    <div style={{color: "#FAFAFA"}}>Select Taste</div>
                                </Button>
                            </div>
                        </div>
                    </div>

                </Form>
            </div>
        </div>


        {/*<div className="row h-100">*/}
        {/*    <div className="col-sm-12 my-auto ">*/}
        {/*        <div className="card bg-light justify-content-center px-5 py-5 w-50 text-center" style={{margin: "auto"}}>*/}
        {/*            <h1 style={{color: "#A03A3A"}}>Get Ready to Grub!<br></br></h1>*/}
        {/*            <h3>Here's your Group ID:</h3>*/}
        {/*            <div className="card bg-light justify-content-center px-3 py-5" >*/}
        {/*                <h2>{groupId}</h2>*/}
        {/*            </div>*/}
        {/*            <h3 className="align-content-center">*/}
        {/*                Share this with your friends to<br></br>*/}
        {/*                combine your tastes*/}
        {/*            </h3>*/}
        {/*            <Button variant="primary" type="button" onClick={() => {*/}
        {/*                navigate('/taste', {state: {"name": name, "groupId": groupId, isHost: false}})*/}
        {/*            }}>*/}
        {/*                <b>Select taste</b>*/}
        {/*            </Button>*/}
        {/*        </div>*/}
        {/*    </div>*/}
        {/*</div>*/}


    </div>
);

}

export default GroupId;