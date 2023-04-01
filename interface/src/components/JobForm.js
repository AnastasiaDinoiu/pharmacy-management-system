import {Button, Container, FormGroup, Modal} from "react-bootstrap";
import Form from "react-bootstrap/Form";

export default function JobForm(props) {
    const {
        nume,
        setNume,
        salariu,
        setSalariu,
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
                    <FormGroup className="mb-3" controlId="formNume">
                        <Form.Label>Nume</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu nume"
                            value={nume}
                            onChange={(e) => setNume(e.target.value)}
                        />
                    </FormGroup>
                    <FormGroup className="mb-3" controlId="formSalariu">
                        <Form.Label>Salariu</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu salariul"
                            value={salariu}
                            onChange={(e) => setSalariu(e.target.value)}
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