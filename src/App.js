import './App.css';
import {BrowserRouter,Routes,Route} from "react-router-dom";
import Login from './Components/Login';
import NavigationBar from './Components/NavigationBar';
import Signup from './Components/Signup';
import EmployeeDetails from './Components/Employee/EmployeeDetails';
import AddEmployee from './Components/Employee/AddEmployee';
import EmpDetails from './Components/Employee/EmpDetails';
import EditEmployee from './Components/Employee/EditEmployee';
import Homepage from './Components/Home/Homepage';
import AddCustomer from './Components/Customer/AddCustomer';
import CustomerDetails from './Components/Customer/CustomerDetails';
import CustDetails from './Components/Customer/CustDetails';




function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <NavigationBar/>
    
    <Routes>
    <Route path='/AddCustomer' element={<AddCustomer/>}/>
    <Route path='/CustDetails' element={<CustDetails/>}/>
    <Route path='/AddEmployee' element={<AddEmployee/>}/>
    <Route path='/EmpDetails' element={<EmpDetails/>}/>
    <Route path='/Login' element={<Login/>}/>
    <Route path='/Signup' element={<Signup/>}/>
    <Route path='/homepage' element={<Homepage/>}/>
    <Route path='/EmployeeDetails' element={<EmployeeDetails/>}/>
    <Route path='/CustomerDetails' element={<CustomerDetails/>}/>
    {/*<Route path='/EditEmployee' element={<EditEmployee/>}/>*/}
    </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
