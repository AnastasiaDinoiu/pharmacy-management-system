import React, {useEffect, useState} from "react";
import {getProducers} from "./ProducerTable";
import {Button, Container, Dropdown, DropdownButton, FormGroup, Modal} from "react-bootstrap";
import Form from "react-bootstrap/Form";

export default function MedicineForm(props) {
    const [producatori, setProducatori] = useState([])
    const {
        dci,
        setDci,
        dc,
        setDc,
        ff,
        setFf,
        concentratie,
        setConcentratie,
        idProducator,
        setIdProducator,
        showMessage,
        setShowMessage,
        showError,
        setShowError,
        message,
        setMessage,
        error,
        setError,
        dropdownTitle,
        setDropdownTitle,
        handleSubmit
    } = props;

    useEffect(() => {
        (async function fetchProducers() {
            const producersData = await getProducers()
            setProducatori(producersData)
        })()
    }, [])

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

            <Container style={{paddingTop: '50px'}}>
                <Form onSubmit={handleSubmit}>
                    <FormGroup className="mb-3" controlId="formDCI">
                        <Form.Label>Denumirea comuna internationala</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu denumirea comuna internationala"
                            value={dci}
                            onChange={(e) => setDci(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formDC">
                        <Form.Label>Denumirea comuna</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu denumirea comerciala"
                            value={dc}
                            onChange={(e) => setDc(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formFF">
                        <Form.Label>Forma famaceutica</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu forma farmaceutica"
                            value={ff}
                            onChange={(e) => setFf(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formConcentratie">
                        <Form.Label>Concentratie</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu concentratia"
                            value={concentratie}
                            onChange={(e) => setConcentratie(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formProducator">
                        <Form.Label>Producator</Form.Label>
                        <DropdownButton id="dropdown-gen" title={dropdownTitle}>
                            {producatori.map((producator => (
                                // eslint-disable-next-line react/jsx-no-undef
                                <Dropdown.Item key={producator.idProducator}
                                               onClick={() => {
                                                   setDropdownTitle(producator.numeProducator)
                                                   setIdProducator(producator.idProducator)
                                               }}>
                                    {producator.numeProducator}
                                </Dropdown.Item>
                            )))
                            }
                        </DropdownButton>
                    </FormGroup>
                    <Button className="updateButton" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </>
    )
}