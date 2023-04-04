import {Button, Container, FormGroup, Modal} from "react-bootstrap";
import Form from "react-bootstrap/Form";

export default function ProducerForm(props) {
    const {
        nume,
        setNume,
        tara,
        setTara,
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
                    <FormGroup className="mb-3" controlId="formTara">
                        <Form.Label>Tara</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introdu tara"
                            value={tara}
                            onChange={(e) => setTara(e.target.value)}
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