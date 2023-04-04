import {useEffect, useState} from "react";
import axiosClient from "../utils/axiosClient";
import DiagnoseForm from "../components/DiagnoseForm";

export default function UpdateDiagnose() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
    const [nume, setNume] = useState('')

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    useEffect(() => {
        (async function getDiagnose() {
            try {
                const {data} = await axiosClient().get(`/diagnoses/${id}`)
                if (data) {
                    setNume(data.numeDiagnostic)
                }
            } catch (err) {
                console.error(err)
            }
        })()
    }, [])

    const handleSubmit = async (event) => {
        event.preventDefault()

        if (nume.length < 3) {
            setError('Denumirea trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }

        try {
            const response = await axiosClient().put(`/diagnoses/${id}?nume=${nume}`, {
                nume
            })
            if (response.status === 200) {
                setMessage('Denumirea diagnosticului a fost modificata!')
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