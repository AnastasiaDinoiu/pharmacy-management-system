import {useEffect, useState} from "react";
import "../components/style.css"
import PatientForm from "../components/PatientForm"
import axiosClient from "../utils/axiosClient";

export default function UpdatePatient() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
    const [nume, setNume] = useState('')
    const [prenume, setPrenume] = useState('')
    const [cnp, setCnp] = useState('')

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    useEffect(() => {
        (async function getPatient() {
            try {
                const {data} = await axiosClient().get(`/patients/${id}`)
                if (data) {
                    setNume(data.numePacient)
                    setPrenume(data.prenumePacient)
                    setCnp(data.cnpPacient)
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

        try {
            const response = await axiosClient().put(`/patients/${id}`, {
                nume,
                prenume,
                cnp
            })
            if (response.status === 200) {
                setMessage('Datele pacientului au fost modificate!')
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
            <PatientForm
                nume={nume}
                setNume={setNume}
                prenume={prenume}
                setPrenume={setPrenume}
                cnp={cnp}
                setCnp={setCnp}
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