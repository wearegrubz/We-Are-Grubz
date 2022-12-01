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
        <>
            <div className="row">
                <div className="col">
                    {
                        options.slice(0, 5).map((option, idx) => {
                            return (
                                <Selection handleSelect={props.handleSelect} option={option} key={idx}/>
                            )
                        })
                    }
                </div>
                <div className="col">
                    {
                        options.slice(5, 10).map((option, idx) => {
                            return (
                                <Selection handleSelect={props.handleSelect} option={option} key={idx}/>
                            )
                        })
                    }
                </div>
            </div>
        </>


    );
}

export default SelectionList;