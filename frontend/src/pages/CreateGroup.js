import {useLocation} from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {useEffect, useState} from "react";
import axios from "axios";
import {
    Link,
    useNavigate
} from "react-router-dom";
import group from "./Group";

function CreateGroup() {
    const [name, setName] = useState("");
    const [location, setLocation] = useState("");
    const [groupId, setGroupId] = useState("")

    const onNameChange = (e) => {
        setName(e.target.value)
    }

    const onLocationChange = e => {
        setLocation(e.target.value)
    }

    const navigate = useNavigate()

    useEffect( () => {
        if (groupId){
            navigate('/groupid', {state: {"name": name, "groupId": groupId, isHost: false}})
        }

    }, [groupId])

    const handleGroup = () => {
        const group = {
            "hostId": "N/A",
            "location": location,
            "radius": 40000,
            "tastes": [],
            "members": []
        };

        const addGroup = () => {
             axios.post('http://localhost:8080/api/v1/group/', group)
                .then(response => {
                        setGroupId(response.data)
                    }
                )
        }

        addGroup().then( () => {

            console.log(groupId)

            }
        )

    }

    return (
        <div className="container-fluid" style={{
            height: "90vh",
            backgroundImage: 'url("/assets/images/food_line_art_final.webp")',
            backgroundSize: "cover",

        }}>
            <div className="row h-100">
                <div className="col-sm-12 my-auto ">
                    <Form>
                        <div className="col-sm-12 card justify-content-center mx-auto w-50"  >
                            <div class="mx-5 my-5">
                                <h1> Create a group </h1>
                                <div >
                                    <label htmlFor="exampleInputEmail1" className="form-label">Whats your name?</label>
                                    <Form.Group className="mb-3" controlId="formBasicName">
                                        <Form.Control
                                            type="text"
                                            onChange={onNameChange}
                                            placeholder="Name" />
                                    </Form.Group>
                                </div>

                                <div>
                                    <label htmlFor="exampleInputEmail1" className="form-label">Where are y'all located?</label>
                                    <Form.Group className="mb-3" controlId="formBasicUsername">
                                        <Form.Control type="text"
                                                      onChange={onLocationChange}
                                                      placeholder="City" />
                                    </Form.Group>
                                </div>

                                <Button variant="primary" type="button" onClick={
                                    handleGroup
                                }
                                >
                                    <b>Generate Group</b>
                                </Button>


                                {groupId ?
                                    <h1> <br></br>Your group ID: {groupId}</h1>:
                                    ""

                                }
                                {groupId ?


                                    <Button variant="primary" type="button" onClick={() => {
                                        navigate('/taste', {state: {"name": name, "groupId": groupId, isHost: false}})
                                    }}>
                                        <b>Select taste</b>
                                    </Button>:
                                    ""
                                }
                            </div>
                        </div>

                    </Form>
                </div>
            </div>

    </div>
    );
}

export default CreateGroup;
