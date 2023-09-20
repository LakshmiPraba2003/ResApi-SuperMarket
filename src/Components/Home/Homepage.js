import React from 'react'
import {useNavigate} from "react-router-dom"

export default function Homepage() {
  const navigate = useNavigate();
  const handleEmployee = (e) => {
    e.preventDefault();
     navigate('/EmployeeDetails');
  } 
  const handleCustomer=(e)=>{
    e.preventDefault();
    navigate('/CustomerDetails')
  }
  return (
    <div>
       <h2>Super Market Management</h2>
       <button onClick={handleEmployee}>Manage Employee</button>
       <button onClick={handleCustomer}>Manage Customer</button>
    </div>
  )
}
