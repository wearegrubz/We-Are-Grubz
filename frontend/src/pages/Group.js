import {useLocation} from "react-router-dom";

function Group() {

    const {state} = useLocation();

    const { name, groupId, selections } = state;

    return (
        <>
            <h1>Name: {name}</h1>
            <h1>Group ID: {groupId}</h1>
            <h1>Selections: {selections}</h1>

        </>
    );
}

export default Group;
