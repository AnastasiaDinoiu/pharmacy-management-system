import {useState} from "react";
import EmployeeForm from "../components/EmployeeForm";

export default function UpdateEmployee() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
    const [nume, setNume] = useState('')
    const [prenume, setPrenume] = useState('')
    const [cnp, setCnp] = useState('')
    const [post, setPost] = useState(0)
    const [email, setEmail] = useState('')
    const [telefon, setTelefon] = useState('')
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    const handleSubmit = async (event) => {

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
                message={message}
                setMessage={setMessage}
                error={error}
                setError={setError}
                handleSubmit={handleSubmit}
            />
        </>
    )
}