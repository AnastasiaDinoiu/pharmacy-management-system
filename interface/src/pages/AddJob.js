import {useState} from "react";
import axiosClient from "../utils/axiosClient";
import JobForm from "../components/JobForm";

export default function AddJob() {
    const [nume, setNume] = useState('')
    const [salariu, setSalariu] = useState(0)

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState("")
    const [error, setError] = useState("")

    const handleSubmit = async (event) => {
        event.preventDefault()
        console.log(nume)
        console.log(salariu)
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
            const response = await axiosClient().post('/jobs', {
                nume,
                salariu
            })
            if (response.status === 200) {
                setMessage('Postul a fost inregistrat!')
                setNume('')
                setSalariu(0)
                setShowMessage(true);
                console.log(nume)
                console.log(salariu)
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
    )
}