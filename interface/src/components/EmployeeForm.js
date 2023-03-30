import {Button, Container, Dropdown, DropdownButton, FormGroup} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import React, {useEffect, useState} from 'react';
import axiosClient from "../utils/axiosClient";

export default function EmployeeForm(props) {
    const [posturi, setPosturi] = useState([])
    const [dropdownTitle, setDropdownTitle] = useState('Alege postul')
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
        message,
        setMessage,
        error,
        setError,
        handleSubmit
    } = props;

    useEffect(() => {
        (async function getJobs() {
            try {
                const {data} = await axiosClient().get('/jobs')
                if (data) {
                    setPosturi(data)
                }
            } catch (err) {
                console.error(err)
            }
        })()
    }, [])

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
                    <FormGroup className="mb-3" controlId="formPost">
                        <Form.Label>Post</Form.Label>
                        <DropdownButton id="dropdown-gen" title={dropdownTitle}>
                            {posturi.map((post => (
                                // eslint-disable-next-line react/jsx-no-undef
                                // <Dropdown.Item key={post.idPost} onClick={() => setIdPost(post.idPost)}>
                                <Dropdown.Item key={post.idPost}
                                               onClick={(e) => {
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