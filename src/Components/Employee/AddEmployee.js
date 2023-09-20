
import React, { useState } from 'react'
import axios from 'axios'

import {useNavigate} from "react-router-dom"
export default function AddEmployee() {
    
const[empFname,setempFname]=useState('')
const[empLname,setempLname]=useState('')
const[empMobile,setempMobile]=useState('')
const[empAddr,setempAddr]=useState('')
const navigate = useNavigate();
const handleSubmit = (e) => {
    e.preventDefault();
    const data = {
      
      empFname:empFname,
      empLname:empLname,
      empMobile:empMobile,
      empAddr:empAddr
    }
    console.log(data)
    axios.post(`http://127.0.0.1:8100/saveEmp`,data)
      .then(response => { console.log(response.data) })
      .catch(err => { console.log(err) })
     
    alert("Submitted")
    navigate('/homepage');
  } 
  return (
    <div id="border">
        <form onSubmit={handleSubmit}>
        <div id="border2"> 
        
        <label><b>EMPLOYEE FIRSTNAME : </b></label>
        <input type='text' size={40} onChange={(e)=>setempFname(e.target.value)}></input><br></br><br></br>
        <label><b>EMPLOYEE LASTNAME : </b></label>
        <input type='text' size={40} onChange={(e)=>setempLname(e.target.value)}></input><br></br><br></br>
        <label><b>EMPLOYEE MOBILE : </b></label>
        <input type='text' size={40} onChange={(e)=>setempMobile(e.target.value)}></input><br></br><br></br>
        <label><b>EMPLOYEE ADDRESS: </b></label>
        <input type='text' size={40} onChange={(e)=>setempAddr(e.target.value)}></input><br></br><br></br><br></br>
        
        <button>Add Employee</button>
        </div>
        </form>
    </div>
  )
}