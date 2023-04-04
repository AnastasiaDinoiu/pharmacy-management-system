import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import NoPage from "./pages/NoPage";
import AddPatient from "./pages/AddPatient";
import 'bootstrap/dist/css/bootstrap.min.css';
import UpdatePatient from "./pages/UpdatePatient";
import AddEmployee from "./pages/AddEmployee";
import UpdateEmployee from "./pages/UpdateEmployee";
import AddJob from "./pages/AddJob";
import UpdateJob from "./pages/UpdateJob";
import AddDiagnose from "./pages/AddDiagnose";
import UpdateDiagnose from "./pages/UpdateDiagnose";
import AddDoctor from "./pages/AddDoctor";
import UpdateDoctor from "./pages/UpdateDoctor";
import AddProducer from "./pages/AddProducer";
import UpdateProducer from "./pages/UpdateProducer";
import AddMedicine from "./pages/AddMedicine";
import UpdateMedicine from "./pages/UpdateMedicine";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Layout/>}>
                        <Route index element={<Home/>}/>
                        <Route path="add-patient" element={<AddPatient/>}/>
                        <Route path="patients/:id" element={<UpdatePatient/>}/>
                        <Route path="add-employee" element={<AddEmployee/>}/>
                        <Route path="employees/:id" element={<UpdateEmployee/>}/>
                        <Route path="add-job" element={<AddJob/>}/>
                        <Route path="jobs/:id" element={<UpdateJob/>}/>
                        <Route path="add-diagnose" element={<AddDiagnose/>}/>
                        <Route path="diagnoses/:id" element={<UpdateDiagnose/>}/>
                        <Route path="add-doctor" element={<AddDoctor/>}/>
                        <Route path="doctors/:id" element={<UpdateDoctor/>}/>
                        <Route path="add-producer" element={<AddProducer/>}/>
                        <Route path="producers/:id" element={<UpdateProducer/>}/>
                        <Route path="add-medicine" element={<AddMedicine/>}/>
                        <Route path="medicines/:id" element={<UpdateMedicine/>}/>
                        <Route path="*" element={<NoPage/>}/>
                    </Route>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
