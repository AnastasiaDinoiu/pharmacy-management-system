import axiosClient from "../utils/axiosClient";
import {useEffect, useState} from "react";
import {getPatients} from "./PatientTable";
import {Button, Container, Modal, Table} from "react-bootstrap";
import TransitionModal from "./TransitionModal";

export const getProducers = async () => {
    try {
        const {data} = await axiosClient().get('/producers');
        return data;
    } catch (err) {
        console.error(err);
        return [];
    }
}

export default function ProducerTable() {
    const [producers, setProducers] = useState([])
    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    useEffect(() => {
        (async function fetchProducers() {
            const producersData = await getProducers();
            setProducers(producersData);
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`producers/${id}`)
            if (status === 200) {
                setProducers(producers.filter(producer => producer.idProducator !== id))
                setMessage(`Producer with ${id} id was successfully removed!`)
                setShowMessage(true);
            } else {
                setError(`Producer with ${id} id not found!`)
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

            <TransitionModal table={"producers"} setObjects={setProducers}/>

            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Nume</th>
                        <th>Tara</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        producers.map(
                            producer => (
                                <tr key={producer.idProducator}>
                                    <td>{producer.idProducator}</td>
                                    <td>{producer.numeProducator}</td>
                                    <td>{producer.tara}</td>
                                    <td><Button className="deleteButton"
                                                onClick={() => handleDelete(producer.idProducator)}>Delete</Button></td>
                                    <td><Button className="updateButton"
                                                href={`producers/${producer.idProducator}`}>Update</Button></td>
                                </tr>
                            ))
                    }
                    </tbody>
                </Table>
            </Container>
        </>
    )
}