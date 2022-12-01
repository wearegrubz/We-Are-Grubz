import Image from "react-bootstrap/Image";
import StarsRating from 'stars-rating';

function Recommendation(props) {
    const img_url = props.rec["image_url"]
    const name = props.rec["name"]
    const rating = props.rec["rating"]
    const address = props.rec["location"]["address1"]
    const handleClick = props.handleClick

    return (
        <>
            <div onClick={() => handleClick(props.idx)} className="container my-2">
                <div className="row">
                    <div className="col-sm-4">
                        <Image thumbnail={true} src={img_url}/>
                    </div>
                    <div className="col-sm-8">
                        <div className="row">
                            <h4>{name}</h4>
                        </div>
                        <div className="row">
                            <StarsRating
                                count={5}
                                value={rating}
                                size={10}
                                edit={false}
                                half={true}
                                color2={'#ffd700'}>
                            </StarsRating>
                        </div>
                        <div className="row">
                            <p>{address}</p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Recommendation;