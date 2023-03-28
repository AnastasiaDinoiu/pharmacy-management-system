package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pacienti", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class PatientEntity implements Serializable {

    @Id
    @Column(name = "id_pacient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPacient;

    @Column(name = "nume")
    private String numePacient;

    @Column(name = "prenume")
    private String prenumePacient;

    @Column(name = "cnp")
    private Long cnpPacient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(idPacient, that.idPacient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPacient);
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "idPacient=" + idPacient +
                ", numePacient='" + numePacient + '\'' +
                ", prenumePacient='" + prenumePacient + '\'' +
                ", cnpPacient='" + cnpPacient + '\'' +
                '}';
    }
}
