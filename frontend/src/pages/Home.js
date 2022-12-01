import './Home.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {
    Link,
    useNavigate
} from "react-router-dom";
import Navbar from "../components/Navbar";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import {useState} from "react";



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
            <div class="container-fluid" style={{height: "91vh", backgroundImage: 'url("/assets/images/home_background.jpg")', backgroundSize: "cover"}} >
                <div className="row h-100">
                    <div className="col-sm-12 my-auto ">
                        <div className="card bg-light justify-content-center px-5 py-2 w-50" style={{margin: "auto"}}>
                            <br/>
                            <h1>Dining with friends should be simple.</h1>
                            <br />
                            <h4>Grubz makes it easier to collaborate on mealtime plans.</h4>
                            {/*<br/>*/}
                            <h6 style={{fontFamily: "Hand_Of_Sean", color:"#A03A3A"}}>Start here</h6>
                            {/*<br/>*/}
                            <Form>
                                <Form.Group className="mb-3" controlId="formBasicName">
                                    <Form.Control name={"full_name"} type="text" onChange={onFormChange}
                                                  placeholder="Name"/>
                                </Form.Group>
                                <Form.Group className="mb-3" controlId="formBasicGroupId">
                                    <Form.Control name={"group_id"} type="text" onChange={onFormChange}
                                                  placeholder="Group ID"/>
                                </Form.Group>
                            </Form>
                            <br/>

                            <div className="row align-content-center">
                                <Button id="btn" variant="danger" type="button" size="lg" onClick={() => {
                                    navigate('/taste', {
                                        state: {
                                            name: values["full_name"],
                                            groupId: values["group_id"],
                                            isHost: false
                                        }
                                    })
                                }}>
                                    <div style={{color: "#ECD6AB"}}>Join Grubz Group</div>
                                </Button>
                            </div>

                            <div className="row text-center my-3">
                                <h5>Or, you can create a new group <Link class="link" to='/create'>here.</Link> </h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>

    );
}

export default Home;
