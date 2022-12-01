import Form from "react-bootstrap/Form";

function Selection(props) {

    return (
        <Form.Check
            label={props.option}
            name={props.option}
            type="checkbox"
            id={`checkbox`}
            onChange={e => {props.handleSelect(e)}}
            style={{minHeight: "2.5rem", paddingLeft: "3rem", fontSize: "18px"}}
        />
    );
}

export default Selection;
