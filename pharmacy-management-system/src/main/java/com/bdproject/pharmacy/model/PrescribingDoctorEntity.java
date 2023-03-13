package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "medici_prescriptori", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class PrescribingDoctorEntity implements Serializable {

    @Id
    @Column(name = "parafa_medic_prescriptor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedicPrescriptor;

    @Column(name = "unitate_medicala")
    private String unitateMedicala;

    @Column(name = "nume")
    private String numeMedicPrescriptor;

    @Column(name = "prenume")
    private String prenumeMedicPrescriptor;

    @Column(name = "email")
    private String emailMedicPrescriptor;

    @Column(name = "telefon")
    private String telefonMedicPrescriptor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescribingDoctorEntity that = (PrescribingDoctorEntity) o;
        return Objects.equals(idMedicPrescriptor, that.idMedicPrescriptor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedicPrescriptor);
    }

    @Override
    public String toString() {
        return "PrescribingDoctorEntity{" +
                "idMedicPrescriptor=" + idMedicPrescriptor +
                ", unitateMedicala='" + unitateMedicala + '\'' +
                ", numeMedicPrescriptor='" + numeMedicPrescriptor + '\'' +
                ", prenumeMedicPrescriptor='" + prenumeMedicPrescriptor + '\'' +
                ", emailMedicPrescriptor='" + emailMedicPrescriptor + '\'' +
                ", telefonMedicPrescriptor='" + telefonMedicPrescriptor + '\'' +
                '}';
    }
}
