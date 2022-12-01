import {useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import MemberList from "../components/MemberList";
import Map from "../components/Map";
import RecommendationList from "../components/RecommendationList";
import Recommendation from "../components/Recommendation";
import axios from 'axios';
import './Group.css';


function Group() {

    const {state} = useLocation();

    const { name, groupId, selections } = state;

    const [members, setMembers] = useState([]);

    const [recommendations, setRecommendations] = useState([]);

    const [selected, setSelected] = useState(0)

    const CoordinatesContext = React.createContext()

    useEffect(() => {

        const member = {
            "name": name,
            "selections": selections
        };

        const getMembers = async () => {
               await axios.get('http://localhost:8080/api/v1/group/find/'+groupId)
                .then(response => {
                    response.data.members.map(member => {
                        setMembers(OldValue => [...OldValue, member])
                    })
                })
        }

        const getRecommendations = async () => {
             await axios.get('http://localhost:8080/api/v1/group/recommendation/'+groupId)
                .then(response => {
                    response.data.map(rec => {
                        setRecommendations(OldValue => [...OldValue, rec])
                    })
                })
        }

        getMembers().then(() =>
            getRecommendations().then(() =>
            setSelected(0))
        )

        console.log(recommendations)

    }, []);

    const handleClick = (idx) => {
        console.log(idx)
        setSelected(idx)
    }

    return (
        <>

                <div className="container parentContainer">
                    <div className="row parentRow">
                        <div className="col-lg-4">
                            <div className="row parentDiv">
                                <div className="col-md-12 h-50">
                                    <MemberList members={members}/>
                                </div>
                            </div>
                            <div className="row parentDiv">
                                <div className="col-md-12 h-50">
                                    <RecommendationList handleClick={handleClick} recs={recommendations} selected={selected}/>

                                </div>
                            </div>
                        </div>
                        <div className="col-lg-8">
                            <CoordinatesContext.Provider value={selected}> {
                                typeof recommendations[selected] != "undefined" ?
                                    <Map coordinates={recommendations[selected]["coordinates"]}/> : ""
                            }
                            </CoordinatesContext.Provider>
                        </div>
                    </div>
                </div>

           </>


    );
}

export default Group;
