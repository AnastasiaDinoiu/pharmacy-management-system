import {useEffect, useState} from "react";
import axiosClient from "../utils/axiosClient";
import MedicineForm from "../components/MedicineForm";

export default function UpdateMedicine() {
    const url = window.location.href.split('/')
    const id = url[url.length - 1]
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

    useEffect(() => {
        (async function getMedicine() {
            try {
                const {data} = await axiosClient().get(`/medicines/${id}`)
                if (data) {
                    setDci(data.dci)
                    setDenumireComerciala(data.denumireComerciala)
                    setFormaFarmaceutica(data.formaFarmaceutica)
                    setConcentratie(data.concentratie)
                    setIdProducator(data.producator.idProducator)
                    setDropdownTitle(data.producator.numeProducator)
                }
            } catch (err) {
                console.error(err)
            }
        })()
    }, [])

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
            const response = await axiosClient().put(`/medicines/${id}`, {
                dci,
                denumireComerciala,
                formaFarmaceutica,
                concentratie,
                idProducator
            })
            if (response.status === 200) {
                setMessage('Datele medicamentului au fost modificate!')
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