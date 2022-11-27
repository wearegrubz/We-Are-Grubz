import Selection from "./Selection";

function SelectionList(props) {

    const options = [
        "American",
        "Barbeque",
        "African",
        "Chinese",
        "Brazilian",
        "Italian",
        "Indian",
        "Cuban",
        "Mexican",
        "French"
    ]

    return (

        options.map((option, idx) => {
                return <Selection handleSelect={props.handleSelect} option={option} key={idx}/>
            }
        )
    );
}

export default SelectionList;