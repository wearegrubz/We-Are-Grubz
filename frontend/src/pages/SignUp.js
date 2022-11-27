import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {
    Link,
    useNavigate
} from "react-router-dom";
import {useState} from "react";

function SignUp() {
    const [state, setState] = useState(
        {name: "",
                  username: "",
                  email: "",
                  password: ""
        }
    );

    const navigate = useNavigate()

    const doUserSignUp = function () {
        // Note that this values come from state variables that we've declared before

        console.log(state)
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "name" : state.name,
                "username" : state.username,
                "password": state.password,
                "email" : state.email
            })
        };

        fetch('http://localhost:8080/api/v1/user/', requestOptions)
            .then(
                response => response.json()
            )

    };


    return (
        <Form>
            <h2> Sign Up </h2>
            <Form.Group className="mb-3" controlId="formBasicName">
                <Form.Control
                    type="text"
                    onChange={e => setState(prevValues => ({...prevValues, name : e.target.value}))}
                    placeholder="Name" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicUsername">
                <Form.Control type="text"
                              onChange={e => setState(prevValues => ({...prevValues, username : e.target.value}))}
                              placeholder="Username" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Control type="text"
                              onChange={e => setState(prevValues => ({...prevValues, email : e.target.value}))}
                              placeholder="Email" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Control type="text"
                              onChange={e => setState(prevValues => ({...prevValues, password : e.target.value}))}
                              placeholder="password" />
            </Form.Group>
            <Button variant="primary" type="button" onClick={() => {
                doUserSignUp();
                navigate("/signin")
            }}>
                <h5>Sign Up</h5>
            </Button>
        </Form>
    );
}

export default SignUp;