import {Button, Container, Dropdown, DropdownButton, FormGroup, Modal} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import React, {useEffect, useState} from 'react';
import axiosClient from "../utils/axiosClient";
import {getJobs} from "./JobTable";

export default function EmployeeForm(props) {
    const [posturi, setPosturi] = useState([])
    const {
        nume,
        setNume,
        prenume,
        setPrenume,
        cnp,
        setCnp,
        idPost,
        setIdPost,
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
        dropdownTitle,
        setDropdownTitle,
        handleSubmit
    } = props;

    useEffect(() => {
        (async function fetchJobs() {
            const jobsData = await getJobs()
            setPosturi(jobsData)
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
                    <FormGroup className="mb-3" controlId="formPost">
                        <Form.Label>Post</Form.Label>
                        <DropdownButton id="dropdown-gen" title={dropdownTitle}>
                            {posturi.map((post => (
                                // eslint-disable-next-line react/jsx-no-undef
                                <Dropdown.Item key={post.idPost}
                                               onClick={() => {
                                                   setDropdownTitle(post.numePost)
                                                   setIdPost(post.idPost)
                                               }}>
                                    {post.numePost}
                                </Dropdown.Item>
                            )))
                            }
                        </DropdownButton>
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