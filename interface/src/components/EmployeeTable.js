import {useEffect, useState} from "react";
import axiosClient from "../utils/axiosClient";
import {Button, Container, Table} from "react-bootstrap";

export default function EmployeeTable() {
    const [employees, setEmployees] = useState([])
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    useEffect(() => {
        (async function getEmployees() {
            try {
                const {data} = await axiosClient().get('/employees')
                setEmployees(data)
                console.log(data)
            } catch (err) {
                console.error(err)
            }
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`employees/${id}`)
            if (status === 200) {
                setEmployees(employees.filter(employee => employee.idAngajat !== id))
                setMessage(`Employee with ${id} id was succesfully removed!`)
                setTimeout(() => setMessage(''), 3000)
            } else {
                setError(`Employee with ${id} id not found!`)
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
            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>Id</th>
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