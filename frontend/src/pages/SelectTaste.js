import {useLocation} from "react-router-dom";

function SelectTaste() {

    const {state} = useLocation();
    const { name, groupId } = state;
    console.log(useLocation())
    return (
        <>
            {name}
            {groupId}

        </>
    );
}

export default SelectTaste;
