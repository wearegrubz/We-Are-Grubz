import Form from "react-bootstrap/Form";

function Selection(props) {

    return (
        <Form.Check
            inline
            label={props.option}
            name={props.option}
            type="checkbox"
            id={`inline-checkbox-1`}
            onChange={e => {props.handleSelect(e)}}
        />
    );
}

export default Selection;
