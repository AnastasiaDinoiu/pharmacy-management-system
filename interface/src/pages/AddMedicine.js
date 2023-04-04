import {useState} from "react";
import axiosClient from "../utils/axiosClient";
import MedicineForm from "../components/MedicineForm";

export default function AddMedicine() {
    const [dci, setDci] = useState('')
    const [denumireComerciala, setDenumireComerciala] = useState('')
    const [formaFarmaceutica, setFormaFarmaceutica] = useState('')
    const [concentratie, setConcentratie] = useState('')
    const [idProducator, setIdProducator] = useState(0)
    const [dropdownTitle, setDropdownTitle] = useState('Alege producatorul')

    const [showMessage, setShowMessage] = useState(false);
    const [showError, setShowError] = useState(false);
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    const handleSubmit = async (event) => {
        event.preventDefault()
        if (dci.length < 3) {
            setError('Denumirea comuna internationala trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }
        if (denumireComerciala.length < 3) {
            setError('Denumirea comerciala trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }
        if (formaFarmaceutica.length < 3) {
            setError('Forma farmaceutica trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }
        if (denumireComerciala.length < 3) {
            setError('Concentratia trebuie sa aiba minim 3 caractere')
            setShowError(true);
            return
        }
        const data = await axiosClient().get(`/producers/${idProducator}`)
        if (!data) {
            setError('Producator invalid')
            setShowError(true);
            return
        }

        try {
            const response = await axiosClient().post('/medicines', {
                dci,
                denumireComerciala,
                formaFarmaceutica,
                concentratie,
                idProducator
            })
            if (response.status === 200) {
                setMessage('Medicamentul a fost inregistrat!')
                setDci('')
                setDenumireComerciala('')
                setFormaFarmaceutica('')
                setConcentratie('')
                setIdProducator(0)
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
            <MedicineForm
                dci={dci}
                setDci={setDci}
                dc={denumireComerciala}
                setDc={setDenumireComerciala}
                ff={formaFarmaceutica}
                setFf={setFormaFarmaceutica}
                concentratie={concentratie}
                setConcentratie={setConcentratie}
                idProducator={idProducator}
                setIdProducator={setIdProducator}
                showMessage={showMessage}
                setShowMessage={setShowMessage}
                showError={showError}
                setShowError={setShowError}
                message={message}
                setMessage={setMessage}
                error={error}
                setError={setError}
                dropdownTitle={dropdownTitle}
                setDropdownTitle={setDropdownTitle}
                handleSubmit={handleSubmit}
            />
        </>
    )
}