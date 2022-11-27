import {useLocation} from "react-router-dom";
import {useState} from "react";
import SelectionList from '../components/SelectionList';
import {
    Link,
    useNavigate
} from "react-router-dom";
import Button from "react-bootstrap/Button";

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

    return (
        <>
            <SelectionList handleSelect={handleSelect}/>
            <Button variant="primary" type="button" onClick={() => {
                navigate('/group', {state: {"name": name, "groupId": groupId, "selections": selections}})
            }}>
                <h5>Join</h5>
            </Button>
        </>


    );
}

export default SelectTaste;
