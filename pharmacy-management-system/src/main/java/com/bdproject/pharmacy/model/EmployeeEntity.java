package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "angajati", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeEntity implements Serializable {

    @Id
    @Column(name = "id_angajat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAngajat;

    @Column(name = "nume")
    private String numeAngajat;

    @Column(name = "prenume")
    private String prenumeAngajat;

    @Column(name = "cnp")
    private Long cnpAngajat;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private JobEntity post;

    @Column(name = "email")
    private String emailAngajat;

    @Column(name = "telefon")
    private String telefonAngajat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(idAngajat, that.idAngajat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAngajat);
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "idAngajat=" + idAngajat +
                ", numeAngajat='" + numeAngajat + '\'' +
                ", prenumeAngajat='" + prenumeAngajat + '\'' +
                ", cnpAngajat='" + cnpAngajat + '\'' +
                ", post=" + post +
                ", emailAngajat='" + emailAngajat + '\'' +
                ", telefonAngajat='" + telefonAngajat + '\'' +
                '}';
    }
}
