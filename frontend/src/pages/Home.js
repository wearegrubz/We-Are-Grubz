import './Home.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {
    BrowserRouter as Router,
    Routes,
    Route,
    Link, useNavigate
} from "react-router-dom";
import Navbar from "../components/Navbar";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import {useRef, useState} from "react";


function Home() {

    const [values, setValues] = useState({"full_name": "", "group_id": ""});

    const navigate = useNavigate()

    const onFormChange = (e) => {
        if (e.target.name === "full_name") {
            setValues(prevValues => ({...prevValues, full_name : e.target.value}))
        } else {
            setValues(prevValues => ({...prevValues, group_id : e.target.value}))
        }

        console.log(values);
    };

    return (

        <>
            <div className="container h-100 d-flex justify-content-center">
                    <div className="col-md-8">
                        <h1 className="text-center mx-auto my-auto align-items-center">
                            Dining with friends should be simple.
                        </h1>
                    </div>
            </div>

            <Form>
                <h2> Enter Name and Group ID to get started! </h2>
                <Form.Group className="mb-3" controlId="formBasicName">
                    <Form.Control name={"full_name"} type="text" onChange={onFormChange} placeholder="Name" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicGroupId">
                    <Form.Control name={"group_id"} type="text" onChange={onFormChange} placeholder="Group ID" />
                </Form.Group>
                <Button variant="primary" type="button" onClick={() => {
                    navigate('/taste', {state: {name: values["full_name"], groupId: values["group_id"]}})
                }}>
                    <h5>Join</h5>
                </Button>
            </Form>
        </>

    );
}

export default Home;
