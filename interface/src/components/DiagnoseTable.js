import axiosClient from "../utils/axiosClient";
import {useEffect, useState} from "react";
import {Button, Container, Modal, Table} from "react-bootstrap";
import "./style.css"
import TransitionModal from "./TransitionModal";

export const getDiagnoses = async () => {
    try {
        const {data} = await axiosClient().get('/diagnoses')
        return data
    } catch (err) {
        console.error(err)
        return []
    }
}

export default function DiagnoseTable() {
    const [diagnoses, setDiagnoses] = useState([])
    const [showMessage, setShowMessage] = useState(false)
    const [showError, setShowError] = useState(false)
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    useEffect(() => {
        (async function fetchDiagnoses() {
            const diagnosesData = await getDiagnoses()
            setDiagnoses(diagnosesData)
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`diagnoses/${id}`)
            if (status === 200) {
                setDiagnoses(diagnoses.filter(diagnose => diagnose.idDiagnostic !== id))
                setMessage(`Diagnose with ${id} id was successfully removed!`)
                setShowMessage(true)
            } else {
                setError(`Diagnose with ${id} id not found!`)
                setShowError(true)
            }
        } catch (err) {
            setError('Server error')
            setShowError(true)
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

            <TransitionModal table={"diagnoses"} setObjects={setDiagnoses}/>

            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Denumire</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        diagnoses
                            .sort((a, b) => a.idDiagnostic - b.idDiagnostic)
                            .map(
                            diagnose => (
                                <tr key={diagnose.idDiagnostic}>
                                    <td>{diagnose.idDiagnostic}</td>
                                    <td>{diagnose.numeDiagnostic}</td>
                                    <td><Button className="deleteButton"
                                                onClick={() => handleDelete(diagnose.idDiagnostic)}>Delete</Button></td>
                                    <td><Button className="updateButton"
                                                href={`diagnoses/${diagnose.idDiagnostic}`}>Update</Button></td>
                                </tr>
                            ))
                    }
                    </tbody>
                </Table>
            </Container>
        </>
    )
}