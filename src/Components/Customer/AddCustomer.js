
import React, { useState } from 'react'
import axios from 'axios'

import {useNavigate} from "react-router-dom"
export default function AddCustomer() {
    
const[custName,setcustName]=useState('')
const[custMobile,setcustMobile]=useState('')
const[custAddr,setcustAddr]=useState('')
const navigate = useNavigate();
const handleSubmit = (e) => {
    e.preventDefault();
    const data = {
      
      custName:custName,
      custMobile:custMobile,
      custAddr:custAddr
    }
    console.log(data)
    axios.post(`http://127.0.0.1:8100/save`,data)
      .then(response => { console.log(response.data) })
      .catch(err => { console.log(err) })
     
    alert("Submitted")
    navigate('/homepage');
  } 
  return (
    <div id="border">
        <form onSubmit={handleSubmit}>
        <div id="border2"> 
        
        <label><b>CUSTOMER NAME: </b></label>
        <input type='text' size={40} onChange={(e)=>setcustName(e.target.value)}></input><br></br><br></br>
        <label><b>CUSTOMER MOBILE : </b></label>
        <input type='text' size={40} onChange={(e)=>setcustMobile(e.target.value)}></input><br></br><br></br>
        
        <label><b>CUSTOMER ADDRESS: </b></label>
        <input type='text' size={40} onChange={(e)=>setcustAddr(e.target.value)}></input><br></br><br></br><br></br>
        
        <button>Add Customer</button>
        </div>
        </form>
    </div>
  )
}