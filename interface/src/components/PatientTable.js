import {useEffect, useState} from "react";
import {Button, Container, Table} from "react-bootstrap";
import axiosClient from "../utils/axiosClient";
import "./style.css"

export default function PatientTable() {
    const [patients, setPatients] = useState([])
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    useEffect(() => {
        (async function getPatients() {
            try {
                const {data} = await axiosClient().get('/patients')
                setPatients(data)
                console.log(data)
            } catch (err) {
                console.error(err)
            }
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`patients/${id}`)
            if (status === 200) {
                setPatients(patients.filter(patient => patient.idPacient !== id))
                setMessage(`Patient with ${id} id was successfully removed!`)
                setTimeout(() => setMessage(''), 3000)
            } else {
                setError(`Patient with ${id} id not found!`)
                setTimeout(() => setMessage(''), 3000)
            }
        } catch (err) {
            setError('Server error')
            setTimeout(() => setMessage(''), 3000)
        }
    }

    return (
        <>
            {
                message ?
                    <div className="message">
                        <p>
                            {message}
                            <span className="closeNotification" onClick={() => setMessage('')}>x</span>
                        </p>
                    </div> : null
            }
            {
                error ?
                    <div className="error">
                        <p>
                            {error}
                            <span className="closeNotification closeNotificationErr"
                                  onClick={() => setError('')}>x</span>
                        </p>
                    </div> : null
            }
            <Container style={{paddingTop: '30px'}}>
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