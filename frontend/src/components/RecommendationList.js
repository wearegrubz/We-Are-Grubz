import Recommendation from "./Recommendation";

function RecommendationList(props) {

    return (
        <>
            {props.recs.map((rec, idx) =>
                <Recommendation handleClick={props.handleClick} idx={idx} rec={rec}/>
            )}
        </>
    );
}

export default RecommendationList;