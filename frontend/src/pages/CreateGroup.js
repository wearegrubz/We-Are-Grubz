import {useLocation} from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {useEffect, useState} from "react";
import axios from "axios";
import {
    Link,
    useNavigate
} from "react-router-dom";

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

    const handleGroup = () => {

        const group = {
            "hostId": "N/A",
            "location": location,
            "radius": 40000,
            "tastes": [],
            "members": []
        };

        const addGroup = async () => {
            await axios.post('http://localhost:8080/api/v1/group/', group)
                .then(response =>{
                        setGroupId(response.data)
                    }
                )
        }

        addGroup()

    }

    return (
        <Form>
            <div class="px-5 pt-5 mx-5">
                <h1> Create a group </h1>
                <div >
                    <label htmlFor="exampleInputEmail1" className="form-label">Whats your name?</label>
                    <Form.Group className="mb-3" controlId="formBasicName">
                        <Form.Control
                            type="text"
                            onChange={onNameChange}
                            placeholder="Vanessa " />
                    </Form.Group>
                </div>

                <div>
                    <label htmlFor="exampleInputEmail1" className="form-label">Where are y'all located?</label>
                    <Form.Group className="mb-3" controlId="formBasicUsername">
                        <Form.Control type="text"
                                      onChange={onLocationChange}
                                      placeholder="Tallahassee" />
                    </Form.Group>
                </div>

                <Button variant="primary" type="button" onClick={handleGroup}>
                    <b>Generate Group</b>
                </Button>

                <h1> Your group ID: {groupId}</h1>

                {groupId ?
                    <Button variant="primary" type="button" onClick={() => {
                        navigate('/taste', {state: {"name": name, "groupId": groupId, isHost: false}})
                    }}>
                        <b>Select taste</b>
                    </Button> :
                    ""
                }
            </div>
        </Form>

    );
}

export default CreateGroup;
