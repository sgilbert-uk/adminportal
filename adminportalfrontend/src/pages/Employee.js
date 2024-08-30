import React, { useEffect, useState } from 'react';
import { useLocation} from 'react-router-dom';
import './stylesheets/Employee.css';

export default function Employee(){
    const location = useLocation();
    const empId = location.state.id;
    const[emp, setEmp] = useState([]);

    const fetchModelData = () => {
        fetch(`http://localhost:8080/emp/get/${empId}`)
          .then(response => {
            return response.json()
          })
          .then(data => {
            setEmp(data)
          })
      }

    useEffect(() => {
        fetchModelData()
    })

    return(
        <div>
            <div classname="employeeInfo">
                <h1>{emp.firstName} {emp.lastName}</h1>
                <p> Employee Id: {emp.id} </p>
                <p> Org Id: {emp.orgId} </p>
                <p> Username: {emp.userName} </p>
                <p> Password: {emp.password} </p>
                <p> Email: {emp.email} </p>
                <p> TelNo: {emp.telNo} </p>
            </div>
        </div>
    )
}