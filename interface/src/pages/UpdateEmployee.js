import {useEffect, useState} from "react";
import EmployeeForm from "../components/EmployeeForm";
import axiosClient from "../utils/axiosClient";

export default function UpdateEmployee() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
    const [nume, setNume] = useState('')
    const [prenume, setPrenume] = useState('')
    const [cnp, setCnp] = useState('')
    const [idPost, setIdPost] = useState(0)
    const [email, setEmail] = useState('')
    const [telefon, setTelefon] = useState('')

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    useEffect(() => {
        (async function getEmployee() {
            try {
                const {data} = await axiosClient().get(`/employees/${id}`)
                if (data) {
                    setNume(data.numeAngajat)
                    setPrenume(data.prenumeAngajat)
                    setCnp(data.cnpAngajat)
                    setIdPost(data.post.idPost)
                    setEmail(data.emailAngajat)
                    setTelefon(data.telefonAngajat)
                }
            } catch (err) {
                console.error(err)
            }
        })()
    }, [])

    const handleSubmit = async (event) => {
        event.preventDefault()

        if (nume.length < 3) {
            setError('Numele trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }
        if (prenume.length < 3) {
            setError('Prenumele trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }
        let strCnp = cnp.toString()
        if (strCnp.length !== 13) {
            setError('CNP invalid')
            setShowError(true);
            return
        }
        const data = await axiosClient().get(`/jobs/${idPost}`)
        if (!data) {
            setError('Post invalid')
            setShowError(true);
            return
        }
        if (email.length < 3) {
            setError('Email invalid')
            setShowError(true);
            return
        }
        if (telefon.length !== 10) {
            setError('Numar de telefon invalid')
            setShowError(true);
            return
        }

        try {
            const response = await axiosClient().put(`/employees/${id}`, {
                nume,
                prenume,
                cnp,
                idPost,
                email,
                telefon
            })
            if (response.status === 200) {
                setMessage('Datele angajatului au fost modificate!')
                setNume('')
                setPrenume('')
                setCnp(0)
                setShowMessage(true);
            } else {
                setError('Database error')
                setShowError(true);
            }
        } catch (err) {
            setError('Database error')
            setShowError(true);
        }
    }

    return (
        <>
            <EmployeeForm
                nume={nume}
                setNume={setNume}
                prenume={prenume}
                setPrenume={setPrenume}
                cnp={cnp}
                setCnp={setCnp}
                idPost={idPost}
                setIdPost={setIdPost}
                email={email}
                setEmail={setEmail}
                telefon={telefon}
                setTelefon={setTelefon}
                showMessage={showMessage}
                setShowMessage={setShowMessage}
                showError={showError}
                setShowError={setShowError}
                message={message}
                setMessage={setMessage}
                error={error}
                setError={setError}
                handleSubmit={handleSubmit}
            />
        </>
    )
}