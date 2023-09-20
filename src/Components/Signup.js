
import React, { useState } from 'react'
import axios from 'axios'
import {useNavigate} from "react-router-dom"

export default function Signup() {
    
const[fname,setfname]=useState('')
const[lname,setlname]=useState('')
const[emailid,setemailid]=useState('')
const[password,setpassword]=useState('')
const navigate = useNavigate();
const handleSubmit = (e) => {
    e.preventDefault();
    const data = {
      fname:fname,
      
      lname:lname,
      emailid:emailid,
      password:password
    }
    console.log(data)
    axios.post(`http://127.0.0.1:8100/addlogin`,data)
      .then(response => { console.log(response.data) })
      .catch(err => { console.log(err) })
     
    alert("Submitted")
    navigate('/homepage');

    console.log(data)
    axios.post(`http://127.0.0.1:8100/addsignup`,data)
      .then(response => { console.log(response.data) })
      .catch(err => { console.log(err) })
     
    // alert("Submitted")
    // navigate('/homepage');
    
  } 
  return (
    <div id="border">
        <form onSubmit={handleSubmit}>
        <div id="border2"> 
        <label><b>FIRST NAME : </b></label>
        <input type='text' size={40} onChange={(e)=>setfname(e.target.value)}></input><br></br><br></br>
        
        <label><b>LAST NAME : </b></label>
        <input type='text' size={40} onChange={(e)=>setlname(e.target.value)}></input><br></br><br></br>
        <label><b>EMAIL ID : </b></label>
        <input type='email' size={40} onChange={(e)=>setemailid(e.target.value)}></input><br></br><br></br><br></br>
        <label><b>PASSWORD : </b></label>
        <input type='password' size={40} onChange={(e)=>setpassword(e.target.value)}></input><br></br><br></br>
        <button>CREATE</button>
        </div>
        </form>
    </div>
  )
}