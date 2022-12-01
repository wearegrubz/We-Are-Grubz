import Recommendation from "./Recommendation";

function RecommendationList(props) {

    return (
        <>
            {props.recs.map((rec, idx) =>
                <Recommendation handleClick={props.handleClick} rec={rec} idx={idx} active={idx===props.selected}/>
            )}
        </>
    );
}

export default RecommendationList;