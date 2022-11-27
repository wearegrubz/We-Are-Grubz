import {useLocation} from "react-router-dom";
import {useEffect, useState} from "react";
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

        const updateMembers = () => {
            axios.post('http://localhost:8080/api/v1/group/add/member/'+groupId, member)
                .then(response =>{
                    console.log(response)
                }
            )
        }

        const getMembers = async () => {
            let new_members = []
              await axios.get('http://localhost:8080/api/v1/group/find/'+groupId)
                .then(response => {
                    setMembers(response.data.members)
                })
        }

        const getRecommendations = async () => {
            await axios.get('http://localhost:8080/api/v1/group/recommendation/'+groupId)
                .then(response => {
                    setRecommendations( response.data)
                })
        }

        updateMembers()
        getRecommendations()
        getMembers()
        console.log(recommendations)

    }, []);


    return (
        <>
            <h1>Name: {name}</h1>
            <h1>Group ID: {groupId}</h1>
            <h1>Selections: {selections}</h1>
            <h1>Members: {members.map(member => <p>{member.name}</p>)}</h1>
            <h1>Reccomendations: {recommendations.map(rec => <p>{rec.name}</p>)}</h1>
        </>
    );
}

export default Group;
