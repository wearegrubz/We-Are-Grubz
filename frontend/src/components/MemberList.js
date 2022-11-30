import Member from "./Member";

function MemberList(props) {

    return (
        <>
            {console.log(props.members)}
            {props.members.map(member =>
                <Member name={member.name} selections={member.selections}/>
            )}
        </>
    );
}

export default MemberList;