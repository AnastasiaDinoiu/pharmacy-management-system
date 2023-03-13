package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "diagnostice", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class DiagnoseEntity implements Serializable {

    @Id
    @Column(name = "cod_diagnostic")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnostic;

    @Column(name = "denumire_diagnostic")
    private String numeDiagnostic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnoseEntity that = (DiagnoseEntity) o;
        return Objects.equals(idDiagnostic, that.idDiagnostic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiagnostic);
    }

    @Override
    public String toString() {
        return "DiagnoseEntity{" +
                "codDiagnostic=" + idDiagnostic +
                ", numeDiagnostic='" + numeDiagnostic + '\'' +
                '}';
    }
}
