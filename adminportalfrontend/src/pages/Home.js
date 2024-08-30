import React, { useEffect, useState} from 'react';
import { Link } from "react-router-dom";

function checkExpDate(org){
       const currentDate = new Date().toLocaleDateString('en-CA');
       let dayDiff = Math.floor(new Date(org.expDate) - new Date(currentDate)) / (1000 * 60 * 60 * 24);

       if (currentDate > org.expDate){
            //do a call to autodisable the service
            return "expired"
       } else if (dayDiff < 7 && dayDiff > 0) {
            return "warning"
       } else {
            return "orgCollection"
       }
}

export default function Home(){
    const[orgs, setOrgs] = useState([]);

    const deleteOrg = (orgId) => {
        fetch(`http://localhost:8080/org/delete/${orgId}`, { method: "DELETE"})
                  .then(response => {
                  window.location.reload();
        })
    }

    const fetchModelData = () => {
        fetch("http://localhost:8080/org/get/all")
          .then(response => {
            return response.json()
          })
          .then(data => {
            setOrgs(data)
          })
      }

    useEffect(() => {
        fetchModelData()
    }, [])

    return(
        <div>
        <h1>Home</h1>
            {orgs.map(org => (
            <div className = {checkExpDate(org)}>
                <h4> Warning - Organisation expires soon </h4>
                <p key={org.id}><h3> {org.orgName}</h3></p>
                <button type="button"><Link to="/Organisation" state={org}>Details</Link></button>
                <button id= "delete" type="button" onClick={() => deleteOrg(org.id)}>Delete</button>
            </div>
            ))}
        </div>
    )
}