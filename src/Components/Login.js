import React from 'react'
import axios from 'axios'
import { useState} from 'react'
import {useNavigate,Link} from "react-router-dom"


export default function Login() {
  const[emailid,setemailid]=useState('')
const[password,setpassword]=useState('')
const[check,setcheck]=useState('')
const handle=(e)=>{
  e.preventDefault();
  navigate('/createaccount')
}
const handleSubmit =  (e) => {
    e.preventDefault();
    axios.get(`http://127.0.0.1:8100/getlogin/${emailid}/${password}`)
    .then(res => setcheck(res.data))
  //const check=true;
  if(check===true){
    navigate('/homepage');
    console.log("valid");
}
  else if(check===false){
    console.log("invalid");
    alert('Invalid credential')
  }
  
}
const del =(e)=>{
  e.preventDefault();
  navigate('/delete')
}
  const navigate = useNavigate();
  return (
    <div className='login'>
      
    <form>
        <label><b>EMAIL ID     :</b></label>
        <input type='email' name="Email" id="email" placeholder="Email" size={40} onChange={(e)=>setemailid(e.target.value)}></input><br></br><br></br><br></br>
        <label><b>PASSWORD      :</b></label>
        <input type='password' name="Password" id="password" placeholder="Password" size={40} onChange={(e)=>setpassword(e.target.value)}></input><br></br><br></br>
        <button onClick={handleSubmit}>LOGIN</button>
         <button onClick={handle}>Signup</button>     
         <Link to="/createaccount" onClick={del}>Forgot Password</Link>
    </form>
    <br></br><br></br>
    </div>
  )
  }