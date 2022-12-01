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
            <h1> Create a group </h1>
            <h3>Whats your name?</h3>
            <Form.Group className="mb-3" controlId="formBasicName">
                <Form.Control
                    type="text"
                    onChange={onNameChange}
                    placeholder="Name" />
            </Form.Group>
            <h3>Whats the location of your group?</h3>
            <Form.Group className="mb-3" controlId="formBasicUsername">
                <Form.Control type="text"
                              onChange={onLocationChange}
                              placeholder="Location" />
            </Form.Group>
            <Button id="btn" variant="primary" type="button" onClick={handleGroup}>
                <h5>Generate Group ID</h5>
            </Button>

            <h1> Your group ID: {groupId}</h1>

            {groupId ?
                <Button id="btn" variant="primary" type="button" onClick={() => {
                    navigate('/taste', {state: {"name": name, "groupId": groupId, isHost: false}})
                }}>
                    <h5>Select taste</h5>
                </Button> :
                ""
            }

        </Form>

    );
}

export default CreateGroup;
