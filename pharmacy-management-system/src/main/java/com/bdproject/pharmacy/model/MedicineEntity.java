package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "medicamente", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class MedicineEntity implements Serializable {

    @Id
    @Column(name = "id_medicament")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedicament;

    @Column(name = "dci")
    private String dci;

    @Column(name = "denumire_comerciala")
    private String denumireComerciala;

    @Column(name = "forma_farmaceutica")
    private String formaFarmaceutica;

    @Column(name = "concentratie")
    private String concentratie;

    @ManyToOne
    @JoinColumn(name = "id_producator")
    private ProducerEntity producator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineEntity that = (MedicineEntity) o;
        return Objects.equals(idMedicament, that.idMedicament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedicament);
    }

    @Override
    public String toString() {
        return "MedicineEntity{" +
                "idMedicament=" + idMedicament +
                ", dci='" + dci + '\'' +
                ", denumireComerciala='" + denumireComerciala + '\'' +
                ", formaFarmaceutica='" + formaFarmaceutica + '\'' +
                ", concentratie='" + concentratie + '\'' +
                ", producator=" + producator +
                '}';
    }
}
