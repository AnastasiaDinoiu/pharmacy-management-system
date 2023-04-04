import React from 'react'
import {Button, Container} from "react-bootstrap";
import '@emotion/react';
import {Backdrop, Box, Fade, Modal} from "@mui/material";
import AddPatient from "../pages/AddPatient";
import {getJobs} from "./JobTable";
import {getPatients} from "./PatientTable";
import AddEmployee from "../pages/AddEmployee";
import {getEmployees} from "./EmployeeTable";
import AddJob from "../pages/AddJob";
import AddDiagnose from "../pages/AddDiagnose";
import {getDiagnoses} from "./DiagnoseTable";
import {getDoctors} from "./DoctorTable";
import AddDoctor from "../pages/AddDoctor";
import AddProducer from "../pages/AddProducer";
import {getProducers} from "./ProducerTable";
import {getMedicines} from "./MedicineTable";
import AddMedicine from "../pages/AddMedicine";

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 500,
    bgcolor: 'background.paper',
    boxShadow: 24,
    p: 7,
};

export default function TransitionModal(props) {
    const [open, setOpen] = React.useState(false);

    const handleOpen = () => setOpen(true);

    const handleClose = async () => {
        let data
        switch (table) {
            case "patients":
                data = await getPatients();
                break
            case "employees":
                data = await getEmployees();
                break
            case "jobs":
                data = await getJobs();
                break
            case "diagnoses":
                data = await getDiagnoses();
                break
            case "doctors":
                data = await getDoctors();
                break
            case "producers":
                data = await getProducers();
                break
            case "medicines":
                data = await getMedicines();
                break
            default:
                return []
        }
        setObjects(data);
        setOpen(false)
    }
    const {table, setObjects} = props;

    function handleTableSelect() {
        // eslint-disable-next-line default-case
        switch (table) {
            case "patients":
                return <AddPatient/>
            case "employees":
                return <AddEmployee/>
            case "jobs":
                return <AddJob/>
            case "diagnoses":
                return <AddDiagnose/>
            case "doctors":
                return <AddDoctor/>
            case "producers":
                return <AddProducer/>
            case "medicines":
                return <AddMedicine/>
            default:
                return ""
        }
    }

    return (
        <div className="transitionModal">
            <Button className="updateButton addButton" onClick={handleOpen}>Add</Button>
            <Modal
                className="addModal"
                aria-labelledby="transition-modal-title"
                aria-describedby="transition-modal-description"
                open={open}
                onClose={handleClose}
                closeAfterTransition
                slots={{backdrop: Backdrop}}
                slotProps={{
                    backdrop: {
                        timeout: 500,
                    },
                }}
                style={{zIndex: 1000}}
            >
                <Fade in={open}>
                    <Box sx={style}>
                        <Container>
                            {handleTableSelect()}
                        </Container>
                    </Box>
                </Fade>
            </Modal>
        </div>
    );
}