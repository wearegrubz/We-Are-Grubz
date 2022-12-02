import {useLocation} from "react-router-dom";
import {useState} from "react";
import SelectionList from '../components/SelectionList';
import {
    Link,
    useNavigate
} from "react-router-dom";
import Button from "react-bootstrap/Button";
import axios from "axios";
import Selection from "../components/Selection";
import {Form} from "react-bootstrap";

function SelectTaste() {

    const {state} = useLocation();

    const { name, groupId } = state;

    const navigate = useNavigate()

    const [selections, setSelections] = useState([]);

    const handleSelect = (e) => {
        const selection = e.target.name
        console.log(selection)
        if(e.target.checked){
            console.log("checked")
            setSelections(oldSelections => [...oldSelections, selection]);
        }else{
            console.log("unchecked")
            setSelections(oldSelections => oldSelections.filter(option =>
            option !== selection))
        }

        console.log(selections)
    }

    const handleJoin = () => {

        const member = {
            "name": name,
            "selections": selections
        };

        const updateMembers = async () => {
            await axios.post('http://localhost:8080/api/v1/group/add/member/'+groupId, member)
                .then(response =>{
                        console.log(response)
                        navigate('/group', {state: {"name": name, "groupId": groupId, "selections": selections}})
                    }
                )
        }

        updateMembers()
    }

    return (
        <>
            <div className="container-fluid" style={{height: "90vh", backgroundImage: 'url("/assets/images/food_line_art_final.webp")', backgroundSize: "cover"}}>
                <div className="row h-100">
                    <div className="col-sm-12 my-auto">
                        <Form>
                            <div className="col-sm-12 card justify-content-center mx-auto w-50">
                                <div className="mx-5 my-5">
                                    <h1>Select Your Taste</h1>
                                    <br/>
                                    <h4 style={{color: "#A03A3A"}}><b>Whatcha Feelin?</b></h4>
                                    <br/>
                                    <SelectionList handleSelect={handleSelect}/>
                                    <br/>
                                    <div className="row align-content-center">
                                        <Button id="btn" variant="primary" type="button" size="lg" onClick={() => handleJoin()}>
                                            <div style={{color: "#FAFAFA"}}>Add Your Taste</div>
                                        </Button>
                                    </div>
                                </div>
                            </div>
                        </Form>
                    </div>
                </div>
            </div>


            {/*<div className="container-fluid" style={{height: "90vh", backgroundImage: 'url("/assets/images/food_line_art_final.webp")', backgroundSize: "cover"}}>*/}
            {/*    <div className="row h-100">*/}
            {/*        <div className="col-sm-12 my-auto">*/}
            {/*            <div className="card bg-light justify-content-center px-5 py-2 w-50" style={{margin: "auto"}}>*/}
            {/*                <br/>*/}
            {/*                <h1>Select Your Taste</h1>*/}
            {/*                <br/>*/}
            {/*                <h4>Watcha feelin?</h4>*/}
            {/*                /!*<br/>*!/*/}
            {/*                <SelectionList handleSelect={handleSelect}/>*/}
            {/*                <br/>*/}
            {/*                <Button id="btn" variant="primary" type="button" onClick={() => handleJoin()}>*/}
            {/*                    <div style={{color: "#ECD6AB"}}>Add Your Taste</div>*/}
            {/*                </Button>*/}
            {/*                <br/>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*</div>*/}
        </>

    );
}

export default SelectTaste;
