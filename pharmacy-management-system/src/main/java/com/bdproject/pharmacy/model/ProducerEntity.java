package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "producatori", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class ProducerEntity implements Serializable {

    @Id
    @Column(name = "id_producator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducator;

    @Column(name = "producator")
    private String numeProducator;

    @Column(name = "tara")
    private String tara;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducerEntity that = (ProducerEntity) o;
        return Objects.equals(idProducator, that.idProducator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducator);
    }

    @Override
    public String toString() {
        return "ProducerEntity{" +
                "idProducator=" + idProducator +
                ", numeProducator='" + numeProducator + '\'' +
                ", tara='" + tara + '\'' +
                '}';
    }
}
