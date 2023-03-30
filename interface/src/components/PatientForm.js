import {Button, Container, FormGroup, Modal} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import "../components/style.css"

export default function PatientForm(props) {
    const {
        nume,
        setNume,
        prenume,
        setPrenume,
        cnp,
        setCnp,
        showMessage,
        setShowMessage,
        message,
        setMessage,
        showError,
        setShowError,
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
                    <FormGroup className="mb-3" controlId="formCnp">
                        <Form.Label>CNP</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu CNP"
                            value={cnp}
                            onChange={(e) => setCnp(e.target.value)}
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