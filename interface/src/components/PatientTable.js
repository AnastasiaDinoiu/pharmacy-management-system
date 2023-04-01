import {useEffect, useState} from "react";
import {Button, Container, Modal, Table} from "react-bootstrap";
import axiosClient from "../utils/axiosClient";
import "./style.css"
import TransitionModal from "./TransitionModal";

export const getPatients = async () => {
    try {
        const {data} = await axiosClient().get('/patients');
        return data;
    } catch (err) {
        console.error(err);
        return [];
    }
}

export default function PatientTable() {
    const [patients, setPatients] = useState([])
    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    useEffect(() => {
        (async function fetchPatients() {
            const patientsData = await getPatients();
            setPatients(patientsData);
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`patients/${id}`)
            if (status === 200) {
                setPatients(patients.filter(patient => patient.idPacient !== id))
                setMessage(`Patient with ${id} id was successfully removed!`)
                setShowMessage(true);
            } else {
                setError(`Patient with ${id} id not found!`)
                setShowError(true);
            }
        } catch (err) {
            setError('Server error')
            setShowError(true);
        }
    }


    return (
        <>
            <Modal className="messageModal" show={showMessage} onHide={() => setShowMessage(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>Message</Modal.Title>
                </Modal.Header>
                <Modal.Body>{message}</Modal.Body>
            </Modal>

            <Modal className="errorModal" show={showError} onHide={() => setShowError(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>Error</Modal.Title>
                </Modal.Header>
                <Modal.Body>{error}</Modal.Body>
            </Modal>

            <TransitionModal table={"patients"} setObjects={setPatients}/>

            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nume</th>
                        <th>Prenume</th>
                        <th>CNP</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        patients.map(
                            patient => (
                                <tr key={patient.idPacient}>
                                    <td>{patient.idPacient}</td>
                                    <td>{patient.numePacient}</td>
                                    <td>{patient.prenumePacient}</td>
                                    <td>{patient.cnpPacient}</td>
                                    <td><Button className="deleteButton"
                                                onClick={() => handleDelete(patient.idPacient)}>Delete</Button></td>
                                    <td><Button className="updateButton"
                                                href={`patients/${patient.idPacient}`}>Update</Button></td>
                                </tr>
                            ))
                    }
                    </tbody>
                </Table>
            </Container>
        </>
    )
}