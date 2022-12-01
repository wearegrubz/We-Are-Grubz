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
            <div className="container-fluid" style={{height: "91vh", backgroundImage: 'url("/assets/images/home_background.jpg")', backgroundSize: "cover"}}>
                <div className="row h-100">
                    <div className="col-sm-12 my-auto">
                        <div className="card bg-light justify-content-center px-5 py-2 w-50" style={{margin: "auto"}}>
                            <br/>
                            <h1>Select Your Taste</h1>
                            <br/>
                            <h4>Watcha feelin?</h4>
                            {/*<br/>*/}
                            <SelectionList handleSelect={handleSelect}/>
                            <br/>
                            <Button variant="primary" type="button" onClick={() => handleJoin()}>
                                <h5 style={{color: "#ECD6AB"}}>Join</h5>
                            </Button>
                            <br/>
                        </div>
                    </div>
                </div>
            </div>
        </>

    );
}

export default SelectTaste;
