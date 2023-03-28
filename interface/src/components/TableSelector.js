import Form from 'react-bootstrap/Form';
import {useState} from "react";
import {Container} from "react-bootstrap";
import PatientTable from "./PatientTable";
import EmployeeTable from "./EmployeeTable";
import JobTable from "./JobTable";

function TableSelector() {
    const [tableData, setTableData] = useState(null)

    function handleTableSelect(event) {
        // eslint-disable-next-line default-case
        switch (event.target.value.toLowerCase()) {
            case "patients":
                setTableData(<PatientTable/>)
                break;
            case "employees":
                setTableData(<EmployeeTable/>)
                break;
            case "jobs":
                setTableData(<JobTable/>)
                break;
        }
    }

    return (
        <>
            <Form.Select aria-label="Default select example" onChange={handleTableSelect}>
                <option>Alege un tabel</option>
                <option value="patients">Pacienti</option>
                <option value="employees">Angajati</option>
                <option value="jobs">Posturi</option>
            </Form.Select>
            <Container>
                {tableData}
            </Container>
        </>
    );
}

export default TableSelector;