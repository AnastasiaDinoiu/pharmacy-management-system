import {useEffect, useState} from "react";
import "../components/style.css"
import PatientForm from "../components/PatientForm"
import axiosClient from "../utils/axiosClient";

export default function AddPatient() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
    const [nume, setNume] = useState('')
    const [prenume, setPrenume] = useState('')
    const [cnp, setCnp] = useState(0)
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
            setTimeout(() => setError(''), 3000)
            return
        }
        if (prenume.length < 5) {
            setError('Prenumele trebuie sa aiba minim 3 caractere')
            setTimeout(() => setError(''), 3000)
            return
        }
        let strCnp = cnp.toString()
        if (strCnp.length !== 13) {
            setError('CNP invalid')
            setTimeout(() => setError(''), 3000)
            return
        }
        try {
            const response = await axiosClient().put(`/patients/${id}`, {
                nume,
                prenume,
                cnp
            })
            if (response.status === 200) {
                setMessage('Pacientul a fost inregistrat!')
                setNume('')
                setPrenume('')
                setCnp('')
                setTimeout(() => setMessage(''), 3000)
            } else {
                setError('Database error')
                setTimeout(() => setError(''), 3000)
            }
        } catch (err) {
            setError('Database error')
            setTimeout(() => setError(''), 3000)
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
                message={message}
                setMessage={setMessage}
                error={error}
                setError={setError}
                handleSubmit={handleSubmit}
            />
        </>
    )
}