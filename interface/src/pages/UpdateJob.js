import {useEffect, useState} from "react";
import axiosClient from "../utils/axiosClient";
import JobForm from "../components/JobForm";

export default function AddJob() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
    const [nume, setNume] = useState('')
    const [salariu, setSalariu] = useState(0)

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    useEffect(() => {
        (async function getJob() {
            try {
                const {data} = await axiosClient().get(`/jobs/${id}`)
                if (data) {
                    setNume(data.numePost)
                    setSalariu(data.salariu)
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
        if (salariu <= 1525) {
            setError('Salariu invalid')
            setShowError(true);
            return
        }

        try {
            const response = await axiosClient().put(`/jobs/${id}`, {
                nume,
                salariu
            })
            if (response.status === 200) {
                setMessage('Postul a fost modificat!')
                setNume('')
                setSalariu(0)
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
            <>
                <JobForm
                    nume={nume}
                    setNume={setNume}
                    salariu={salariu}
                    setSalariu={setSalariu}
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
        </>
    )
}