import axiosClient from "../utils/axiosClient";
import {useEffect, useState} from "react";
import {Button, Container, Modal, Table} from "react-bootstrap";
import TransitionModal from "./TransitionModal";

export const getJobs = async () => {
    try {
        const {data} = await axiosClient().get("/jobs")
        return data
    } catch (err) {
        console.error(err)
        return []
    }
}

export default function JobTable() {
    const [jobs, setJobs] = useState([])
    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    useEffect(() => {
        (async function fetchJobs() {
            const jobsData = await getJobs()
            setJobs(jobsData)
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`jobs/${id}`)
            if (status === 200) {
                setJobs(jobs.filter(job => job.idPost !== id))
                setMessage(`Job with ${id} id was successfully removed!`)
                setShowMessage(true)
            } else {
                setError(`Job with ${id} id not found!`)
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

            <TransitionModal table={"jobs"} setObjects={setJobs}/>

            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Nume</th>
                        <th>Salariu</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        jobs.map(
                            job => (
                                <tr key={job.idPost}>
                                    <td>{job.idPost}</td>
                                    <td>{job.numePost}</td>
                                    <td>{job.salariu}</td>
                                    <td><Button className="deleteButton"
                                                onClick={() => handleDelete(job.idPost)}>Delete</Button></td>
                                    <td><Button className="updateButton"
                                                href={`jobs/${job.idPost}`}>Update</Button></td>
                                </tr>
                            )
                        )
                    }
                    </tbody>
                </Table>
            </Container>
        </>
    )
}