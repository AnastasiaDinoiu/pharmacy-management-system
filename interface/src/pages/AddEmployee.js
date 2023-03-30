import {useState} from "react";
import EmployeeForm from "../components/EmployeeForm";
import axiosClient from "../utils/axiosClient";

export default function AddEmployee() {
    const [nume, setNume] = useState('')
    const [prenume, setPrenume] = useState('')
    const [cnp, setCnp] = useState('')
    const [idPost, setIdPost] = useState(0)
    const [email, setEmail] = useState('')
    const [telefon, setTelefon] = useState('')
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    const handleSubmit = async (event) => {
        event.preventDefault()
        if (nume.length < 3) {
            setError('Numele trebuie sa aiba minim 3 caractere')
            setTimeout(() => setError(''), 3000)
            return
        }
        if (prenume.length < 3) {
            setError('Prenumele trebuie sa aiba minim 3 caractere')
            setTimeout(() => setError(''), 3000)
            return
        }
        if (cnp.length !== 13) {
            setError('CNP invalid')
            setTimeout(() => setError(''), 3000)
            return
        }
        console.log(idPost)
        const data = await axiosClient().get(`/jobs/${idPost}`)
        if (!data) {
            setError('Post invalid')
            setTimeout(() => setError(''), 3000)
            return
        }
        if (email.length !== 3) {
            setError('Email invalid')
            setTimeout(() => setError(''), 3000)
            return
        }
        if (telefon.length !== 10) {
            setError('Numar de telefon invalid')
            setTimeout(() => setError(''), 3000)
            return
        }

        try {
            const response = await axiosClient().post('/employees', {
                nume,
                prenume,
                cnp,
                idPost,
                email,
                telefon
            })
            if (response.status === 200) {
                setMessage('Angajatul a fost inregistrat!')
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
                message={message}
                setMessage={setMessage}
                error={error}
                setError={setError}
                handleSubmit={handleSubmit}
            />
        </>
    )
}