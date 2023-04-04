import {Button, Container, FormGroup, Modal} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import React from "react";

export default function DoctorForm(props) {
    const {
        unitateMedicala,
        setUnitateMedicala,
        nume,
        setNume,
        prenume,
        setPrenume,
        email,
        setEmail,
        telefon,
        setTelefon,
        showMessage,
        setShowMessage,
        showError,
        setShowError,
        message,
        setMessage,
        error,
        setError,
        handleSubmit
    } = props;

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
                    <FormGroup className="mb-3" controlId="formUnitateMedicala">
                        <Form.Label>Unitate medicala</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu unitatea medicala"
                            value={unitateMedicala}
                            onChange={(e) => setUnitateMedicala(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formNume">
                        <Form.Label>Nume</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu nume"
                            value={nume}
                            onChange={(e) => setNume(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formPrenume">
                        <Form.Label>Prenume</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu prenume"
                            value={prenume}
                            onChange={(e) => setPrenume(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formEmail">
                        <Form.Label>Email</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu email-ul"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formTelefon">
                        <Form.Label>Telefon</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu numarul de telefon"
                            value={telefon}
                            onChange={(e) => setTelefon(e.target.value)}
                        />
                    </FormGroup>

                    <Button className="updateButton" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </>
    )
}