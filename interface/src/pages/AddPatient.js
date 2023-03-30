import {useState} from "react";
import "../components/style.css"
import PatientForm from "../components/PatientForm"
import axiosClient from "../utils/axiosClient";

export default function AddPatient() {
    const [nume, setNume] = useState('')
    const [prenume, setPrenume] = useState('')
    const [cnp, setCnp] = useState('')

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

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
        if (cnp.length !== 13) {
            setError('CNP invalid')
            setShowError(true);
            return
        }

        try {
            const response = await axiosClient().post('/patients', {
                nume,
                prenume,
                cnp
            })
            if (response.status === 200) {
                setMessage('Pacientul a fost inregistrat!')
                setNume('')
                setPrenume('')
                setCnp('')
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
                message={message}
                setMessage={setMessage}
                showError={showError}
                setShowError={setShowError}
                error={error}
                setError={setError}
                handleSubmit={handleSubmit}
            />
        </>
    )
}