import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {useState} from "react";
import {useNavigate} from "react-router-dom";


function SignIn() {
    const [state, setState] = useState(
        {
            username: "",
            password: ""
        }
    );


    const [currentUser, setCurrentUser] = useState(null);

    const navigate = useNavigate()
    /*
    const doUserLogIn = async function () {
        const currentUser = await Parse.User.currentAsync();
        console.log(currentUser)
        // Note that this values come from state variables that we've declared before
        const usernameValue = state.username;
        const passwordValue = state.password;
        return await Parse.User.logIn(usernameValue, passwordValue)
            .then(async (loggedInUser) => {
                // logIn returns the corresponding ParseUser object
                alert(
                    'Success!',
                    `User ${loggedInUser.get('username')} has successfully signed in!`,
                );
                // To verify that this is in fact the current user, currentAsync can be used
                const currentUser = await Parse.User.currentAsync();
                console.log(loggedInUser === currentUser);
                // Navigation.navigate takes the user to the screen named after the one
                // passed as parameter
                return true;
            })
            .catch((error) => {
                // Error can be caused by wrong parameters or lack of Internet connection
                alert('Error!', error.message);
                return false;
            });
    };


    return (
        <Form>
            <h2> Sign In </h2>
            <Form.Group className="mb-3" controlId="formBasicName">
                <Form.Control
                    type="text"
                    onChange={e => setState(prevValues => ({...prevValues, username : e.target.value}))}
                    placeholder="Username" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicUsername">
                <Form.Control type="text"
                              onChange={e => setState(prevValues => ({...prevValues, password : e.target.value}))}
                              placeholder="Password" />
            </Form.Group>
            <Button variant="primary" type="button" onClick={() => doUserLogIn()}>
                <h5>Sign In</h5>
            </Button>
        </Form>
    );

     */
}

export default SignIn;