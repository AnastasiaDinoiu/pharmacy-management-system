import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import NoPage from "./pages/NoPage";
import AddPatient from "./pages/AddPatient";
import 'bootstrap/dist/css/bootstrap.min.css';
import UpdatePatient from "./pages/UpdatePatient";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Layout/>}>
                        <Route index element={<Home/>}/>
                        <Route path="add-patient" element={<AddPatient/>}/>
                        <Route path="patients/:id" element={<UpdatePatient/>}/>
                        <Route path="*" element={<NoPage/>}/>
                    </Route>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
