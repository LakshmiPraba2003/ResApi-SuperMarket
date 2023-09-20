import React from 'react'
import { Link } from 'react-router-dom'

export default function EmployeeDetails() {
  return (
    <div>
       <h4>Manage Employee</h4>
       <li>
       <Link to="/AddEmployee">AddEmployee</Link>
       </li><li>
       <Link to="/EmpDetails">View Employee</Link>
       </li>
    </div>
  )
}
