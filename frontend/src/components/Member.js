function Member(props) {

    return (
        <>
            <h1>{props.name}'s taste: </h1>
            {props.selections.map(selection =>
                <li><h3>{selection}</h3></li>
            )}
        </>


    );
}

export default Member;