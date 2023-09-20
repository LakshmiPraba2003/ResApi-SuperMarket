import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function CustDetails() {
  const [users, setUsers] = useState([]);

  const { custId } = useParams();

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8100/getmap");
    setUsers(result.data);
  };

  const deleteUser = async (custId) => {
    await axios.delete(`http://localhost:8100/deleteby/${custId}`);
    loadUsers();
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">Customer ID</th>
              <th scope="col">Name</th>
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
                <td>{user.custName}</td>
                <td>{user.custMobile}</td>
                <td>{user.custAddr}</td>
                
                <td>
                   <button 
                   className="btn btn-danger mx-2"
                   onClick={()=>deleteUser(user.custId)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
