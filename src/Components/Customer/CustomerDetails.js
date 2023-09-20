import React from 'react'
import { Link } from 'react-router-dom'

export default function CustomerDetails() {
  return (
    <div>
       <h4>Manage Customer</h4>
       <li>
       <Link to="/AddCustomer">AddCustomer</Link>
       </li><li>
       <Link to="/CustDetails">View Customer</Link>
       </li>
    </div>
  )
}