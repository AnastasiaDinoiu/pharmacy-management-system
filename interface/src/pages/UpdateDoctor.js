import {useEffect, useState} from "react";
import axiosClient from "../utils/axiosClient";
import DoctorForm from "../components/DoctorForm";

export default function UpdateDoctor() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
    const [unitateMedicala, setUnitateMedicala] = useState('')
    const [nume, setNume] = useState('')
    const [prenume, setPrenume] = useState('')
    const [email, setEmail] = useState('')
    const [telefon, setTelefon] = useState('')

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    useEffect(() => {
        (async function getPatient() {
            try {
                const {data} = await axiosClient().get(`/doctors/${id}`)
                if (data) {
                    setUnitateMedicala(data.unitateMedicala)
                    setNume(data.numeMedicPrescriptor)
                    setPrenume(data.prenumeMedicPrescriptor)
                    setEmail(data.emailMedicPrescriptor)
                    setTelefon(data.telefonMedicPrescriptor)
                }
            } catch (err) {
                console.error(err)
            }
        })()
    }, [])

    const handleSubmit = async (event) => {
        event.preventDefault()

        if (unitateMedicala.length < 3) {
            setError('Unitatea medicala trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }
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
            const response = await axiosClient().put(`/doctors/${id}`, {
                unitateMedicala,
                nume,
                prenume,
                email,
                telefon
            })
            if (response.status === 200) {
                setMessage('Datele medicului au fost modificate!')
                setUnitateMedicala('')
                setNume('')
                setPrenume('')
                setEmail('')
                setTelefon('')
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
            <DoctorForm
                unitateMedicala={unitateMedicala}
                setUnitateMedicala={setUnitateMedicala}
                nume={nume}
                setNume={setNume}
                prenume={prenume}
                setPrenume={setPrenume}
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