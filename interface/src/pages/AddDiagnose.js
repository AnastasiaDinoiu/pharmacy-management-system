import {useState} from "react";
import axiosClient from "../utils/axiosClient";
import DiagnoseForm from "../components/DiagnoseForm";

export default function AddDiagnose() {
    const [nume, setNume] = useState('')
    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    const handleSubmit = async (event) => {
        event.preventDefault()

        if (nume.length < 3) {
            setError('Denumirea trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }

        try {
            const response = await axiosClient().post(`/diagnoses?nume=${nume}`, {
                nume
            })
            if (response.status === 200) {
                setMessage('Diagnosticul a fost inregistrat!')
                setNume('')
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
            <DiagnoseForm
                nume={nume}
                setNume={setNume}
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