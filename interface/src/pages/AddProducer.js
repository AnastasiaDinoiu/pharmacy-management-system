import {useState} from "react";
import axiosClient from "../utils/axiosClient";
import ProducerForm from "../components/ProducerForm";

export default function AddProducer() {
    const [nume, setNume] = useState('')
    const [tara, setTara] = useState('')

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
        if (tara.length < 3) {
            setError('Trebuie trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }

        try {
            const response = await axiosClient().post(`/producers?producator=${nume}&tara=${tara}`, {
                nume,
                tara
            })
            if (response.status === 200) {
                setMessage('Producatorul a fost inregistrat!')
                setNume('')
                setTara('')
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
            <ProducerForm
                nume={nume}
                setNume={setNume}
                tara={tara}
                setTara={setTara}
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