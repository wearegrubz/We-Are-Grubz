import { TiUserOutline } from 'react-icons/ti';
import './Member.css';

function Member(props) {

    const selectionRows = () => {
        let rows = {}
        let counter = 1

        props.selections.map((selection, idx) => {
            rows[counter] = rows[counter] ? [...rows[counter]] : []
            if (idx % 4 === 0 && idx !== 0) {
                counter++
                rows[counter] = rows[counter] ? [...rows[counter]] : []
                rows[counter].push(selection)
            } else {
                rows[counter].push(selection)
            }
        })

        return rows
    }

    let rows = selectionRows()

    return (
        <>
            <div class="container border-top mt-2">
                <div className="row">
                    <div className="col-sm-4 h-50">
                        <TiUserOutline class=" mt-1 border border-warning rounded-circle rounded-lg"
                                       style={{height: "40%", width: "60%"}}/>
                    </div>
                    <div className="col-sm-8">
                        <div class="row">
                            <h2>{props.name}</h2>
                        </div>
                        <div class="row">
                            {Object.keys(rows).map(row => {
                                return (
                                    <div className="row" key={row}>
                                        {rows[row].map(selection => {
                                            return(
                                            <div className="col-sm-6">
                                                <span className="badge rounded-pill text-bg-dark mt-2 mx-1" style={{width: "100%", height: "60%", color: "#E76252 !important"}}>{selection}</span>
                                            </div>
                                            )
                                        })}
                                    </div>
                                )
                            })}
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Member;