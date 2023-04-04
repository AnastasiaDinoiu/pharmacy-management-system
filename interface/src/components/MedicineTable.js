import axiosClient from "../utils/axiosClient";
import {useEffect, useState} from "react";
import {Button, Container, Modal, Table} from "react-bootstrap";
import TransitionModal from "./TransitionModal";

export const getMedicines = async () => {
    try {
        const {data} = await axiosClient().get('/medicines');
        return data;
    } catch (err) {
        console.error(err);
        return [];
    }
}

export default function MedicineTable() {
    const [medicines, setMedicines] = useState([])
    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    useEffect(() => {
        (async function fetchMedicines() {
            const medicinesData = await getMedicines();
            setMedicines(medicinesData);
        })()
    }, [])

    const handleDelete = async (id) => {
        try {
            const {status} = await axiosClient().delete(`medicines/${id}`)
            if (status === 200) {
                setMedicines(medicines.filter(medicine => medicine.idMedicament !== id))
                setMessage(`Medicine with ${id} id was successfully removed!`)
                setShowMessage(true);
            } else {
                setError(`Medicine with ${id} id not found!`)
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

            <TransitionModal table={"medicines"} setObjects={setMedicines}/>

            <Container style={{paddingTop: '20px'}}>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>DCI</th>
                        <th>DC</th>
                        <th>FF</th>
                        <th>Concentratie</th>
                        <th>Producator</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        medicines.map(
                            medicine => (
                                <tr key={medicine.idMedicament}>
                                    <td>{medicine.idMedicament}</td>
                                    <td>{medicine.dci}</td>
                                    <td>{medicine.denumireComerciala}</td>
                                    <td>{medicine.formaFarmaceutica}</td>
                                    <td>{medicine.concentratie}</td>
                                    <td>{medicine.producator.numeProducator}</td>
                                    <td><Button className="deleteButton"
                                                onClick={() => handleDelete(medicine.idMedicament)}>Delete</Button></td>
                                    <td><Button className="updateButton"
                                                href={`medicines/${medicine.idMedicament}`}>Update</Button></td>
                                </tr>
                            ))
                    }
                    </tbody>
                </Table>
            </Container>
        </>
    )
}