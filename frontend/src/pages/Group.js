import {useLocation} from "react-router-dom";
import {useEffect, useState} from "react";
import MemberList from "../components/MemberList";
import axios from 'axios';

function Group() {

    const {state} = useLocation();

    const { name, groupId, selections } = state;

    const [members, setMembers] = useState([]);

    const [recommendations, setRecommendations] = useState([]);

    useEffect(() => {

        const member = {
            "name": name,
            "selections": selections
        };

        const updateMembers = async () => {
            await axios.post('http://localhost:8080/api/v1/group/add/member/'+groupId, member)
                .then(response =>{
                    console.log(response)
                }
            )
        }

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
            getRecommendations()
        )

        console.log(recommendations)

    }, []);


    return (
        <>
            <h1>Group ID: {groupId}</h1>
            <MemberList members={members} className="border"/>
            <h1>Reccomendations: {recommendations.map(rec => <p>{rec.name}</p>)}</h1>
        </>
    );
}

export default Group;
