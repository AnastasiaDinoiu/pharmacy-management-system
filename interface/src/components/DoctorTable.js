import axiosClient from "../utils/axiosClient";
import {useEffect, useState} from "react";
import {Button, Container, Modal, Table} from "react-bootstrap";
import TransitionModal from "./TransitionModal";

export const getDoctors = async () => {
    try {
        const {data} = await axiosClient().get('/doctors');
        return data;
    } catch (err) {
        console.error(err);
        return [];
    }
}

export default function DoctorTable() {
    const [doctors, setDoctors] = useState([])
    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    useEffect(() => {
        (async function fetchDoctors() {
            const doctorsData = await getDoctors();
            setDoctors(doctorsData);
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`doctors/${id}`)
            if (status === 200) {
                setDoctors(doctors.filter(doctor => doctor.idMedicPrescriptor !== id))
                setMessage(`Doctor with ${id} id was successfully removed!`)
                setShowMessage(true);
            } else {
                setError(`Doctor with ${id} id not found!`)
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

            <TransitionModal table={"doctors"} setObjects={setDoctors}/>

            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Unitate medicala</th>
                        <th>Nume</th>
                        <th>Prenume</th>
                        <th>Email</th>
                        <th>Telefon</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        doctors.map(
                            doctor => (
                                <tr key={doctor.idMedicPrescriptor}>
                                    <td>{doctor.idMedicPrescriptor}</td>
                                    <td>{doctor.unitateMedicala}</td>
                                    <td>{doctor.numeMedicPrescriptor}</td>
                                    <td>{doctor.prenumeMedicPrescriptor}</td>
                                    <td>{doctor.emailMedicPrescriptor}</td>
                                    <td>{doctor.telefonMedicPrescriptor}</td>
                                    <td><Button className="deleteButton"
                                                onClick={() => handleDelete(doctor.idMedicPrescriptor)}>Delete</Button></td>
                                    <td><Button className="updateButton"
                                                href={`doctors/${doctor.idMedicPrescriptor}`}>Update</Button></td>
                                </tr>
                            ))
                    }
                    </tbody>
                </Table>
            </Container>
        </>
    )
}