import {Button, Container, FormGroup} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import "../components/style.css"

export default function PatientForm(props) {
    const { nume, setNume, prenume, setPrenume, cnp, setCnp, message, setMessage, error, setError, handleSubmit } = props;

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