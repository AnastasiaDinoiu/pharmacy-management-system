package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "posturi", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class JobEntity implements Serializable {

    @Id
    @Column(name = "id_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    @Column(name = "denumire_post")
    private String numePost;

    @Column(name = "salariu")
    private Integer salariu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobEntity jobEntity = (JobEntity) o;
        return Objects.equals(idPost, jobEntity.idPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPost);
    }

    @Override
    public String toString() {
        return "JobEntity{" +
                "idPost=" + idPost +
                ", numePost='" + numePost + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
