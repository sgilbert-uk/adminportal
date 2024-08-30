import  React, { useEffect, useState } from 'react';
import { useLocation, Link } from 'react-router-dom';
import './stylesheets/Organisation.css';

export default function Organisation(){
    const location = useLocation();
    const orgId = location.state.id;
    const[emps, setEmps] = useState([]);

    const deleteEmp = (empId) => {
        fetch(`http://localhost:8080/emp/delete/${empId}`, { method: "DELETE"})
                  .then(response => {
                  window.location.reload();
        })
    }

    const fetchModelData = () => {
          fetch(`http://localhost:8080/emp/get/all/org/${orgId}`)
            .then(response => {
                return response.json()
            })
            .then(data => {
                setEmps(data)
            })
    }


    useEffect(() => {
        fetchModelData()
    })

    return(
        <div>
           <h1>{location.state.orgName} details</h1>
           <div className="orgData">
            <h3> | RegDate: {location.state.regDate} | ExpDate: {location.state.expDate} | Enabled: {location.state.enabled.toString()}</h3>
           </div>
           <h2>{location.state.orgName} employees</h2>
            {emps.map(emp => (
            <div className="employee">
                <p key={emp.id}><h3> {emp.firstName} {emp.lastName}</h3></p>
                <button type="button"><Link to="/Employee" state={emp}>Details</Link></button>
                <button id= "delete" type="button" onClick={() => deleteEmp(emp.id)}>Delete</button>
            </div>
            ))}
        </div>
    )
}