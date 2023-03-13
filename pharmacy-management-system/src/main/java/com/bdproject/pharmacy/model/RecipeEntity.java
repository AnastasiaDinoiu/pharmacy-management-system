package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "retete", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class RecipeEntity implements Serializable {

    @Id
    @Column(name = "id_reteta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReteta;

    @ManyToOne
    @JoinColumn(name = "id_pacient")
    private PatientEntity pacient;

    @ManyToOne
    @JoinColumn(name = "cod_diagnostic")
    private DiagnoseEntity diagnostic;

    @ManyToOne
    @JoinColumn(name = "id_angajat")
    private EmployeeEntity angajat;

    @ManyToOne
    @JoinColumn(name = "parafa_medic_prescriptor")
    private PrescribingDoctorEntity medicPrescriptor;

    @Column(name = "tip_tratament")
    private String tipTratament;

    @Column(name = "data_prescriere")
    private LocalDate dataPrescriere;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeEntity that = (RecipeEntity) o;
        return Objects.equals(idReteta, that.idReteta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReteta);
    }

    @Override
    public String toString() {
        return "RecipeEntity{" +
                "idReteta=" + idReteta +
                ", pacient=" + pacient +
                ", diagnostic=" + diagnostic +
                ", angajat=" + angajat +
                ", medicPrescriptor=" + medicPrescriptor +
                ", tipTratament='" + tipTratament + '\'' +
                ", dataPrescriere=" + dataPrescriere +
                '}';
    }
}
