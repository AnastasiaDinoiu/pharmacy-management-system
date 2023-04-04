import React, {useState} from "react";
import {Container, Dropdown, DropdownButton, FormGroup} from "react-bootstrap";
import PatientTable from "./PatientTable";
import EmployeeTable from "./EmployeeTable";
import JobTable from "./JobTable";
import DiagnoseTable from "./DiagnoseTable";
import DoctorTable from "./DoctorTable";

export default function TableSelector() {
    const [tableData, setTableData] = useState(<PatientTable/>)
    const [dropdownTitle, setDropdownTitle] = useState('Alege tabelul')
    const tables = ["Pacienti", "Angajati", "Posturi", "Diagnostice", "Medici prescriptori"]

    function handleTableSelect(table) {
        // eslint-disable-next-line default-case
        switch (table) {
            case "Pacienti":
                setTableData(<PatientTable/>)
                break;
            case "Angajati":
                setTableData(<EmployeeTable/>)
                break;
            case "Posturi":
                setTableData(<JobTable/>)
                break;
            case "Diagnostice":
                setTableData(<DiagnoseTable/>)
                break;
            case "Medici prescriptori":
                setTableData(<DoctorTable/>)
                break;
        }
    }

    return (
        <>
            <Container>
                <FormGroup className="mb-3" controlId="formPost">
                    <DropdownButton className="tableSelectButton" id="dropdown-gen" title={dropdownTitle}>
                        {tables.map((table => (
                            <Dropdown.Item key={table}
                                           onClick={() => {
                                               setDropdownTitle(table)
                                               handleTableSelect(table)
                                           }}>
                                {table}
                            </Dropdown.Item>
                        )))
                        }
                    </DropdownButton>
                </FormGroup>
                {tableData}
            </Container>
        </>
    );
}