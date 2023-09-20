import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function EmpDetails() {
  const [users, setUsers] = useState([]);

  const { empId } = useParams();

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8100/getmapEmp");
    setUsers(result.data);
  };

  const deleteUser = async (empId) => {
    await axios.delete(`http://localhost:8100/deleteEmpby/${empId}`);
    loadUsers();
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">Employee ID</th>
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Mobile</th>
              <th scope="col">Address</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{user.empFname}</td>
                <td>{user.empLname}</td>
                <td>{user.empMobile}</td>
                <td>{user.empAddr}</td>
                
                <td>
               
                   
                   <button 
                   className="btn btn-danger mx-2"
                   onClick={()=>deleteUser(user.empId)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
