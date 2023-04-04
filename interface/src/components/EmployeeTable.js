import {useEffect, useState} from "react";
import axiosClient from "../utils/axiosClient";
import {Button, Container, Modal, Table} from "react-bootstrap";
import TransitionModal from "./TransitionModal";

export const getEmployees = async () => {
    try {
        const {data} = await axiosClient().get('/employees')
        return data;
    } catch (err) {
        console.error(err)
        return []
    }
}

export default function EmployeeTable() {
    const [employees, setEmployees] = useState([])
    const [showMessage, setShowMessage] = useState(false)
    const [showError, setShowError] = useState(false)
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    useEffect(() => {
        (async function fetchEmployees() {
            const employeesData = await getEmployees()
            setEmployees(employeesData)
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`employees/${id}`)
            if (status === 200) {
                setEmployees(employees.filter(employee => employee.idAngajat !== id))
                setMessage(`Employee with ${id} id was successfully removed!`)
                setShowMessage(true)
            } else {
                setError(`Employee with ${id} id not found!`)
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

            <TransitionModal table={"employees"} setObjects={setEmployees}/>

            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Nume</th>
                        <th>Prenume</th>
                        <th>CNP</th>
                        <th>Post</th>
                        <th>Email</th>
                        <th>Telefon</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        employees.map(
                            employee => (
                                <tr key={employee.idAngajat}>
                                    <td>{employee.idAngajat}</td>
                                    <td>{employee.numeAngajat}</td>
                                    <td>{employee.prenumeAngajat}</td>
                                    <td>{employee.cnpAngajat}</td>
                                    <td>{employee.post.numePost}</td>
                                    <td>{employee.emailAngajat}</td>
                                    <td>{employee.telefonAngajat}</td>
                                    <td><Button className="deleteButton"
                                                onClick={() => handleDelete(employee.idAngajat)}>Delete</Button></td>
                                    <td><Button className="updateButton"
                                                href={`employees/${employee.idAngajat}`}>Update</Button></td>
                                </tr>
                            ))
                    }
                    </tbody>
                </Table>
            </Container>
        </>
    )
}