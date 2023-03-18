package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "retete_medicamente", schema = "pharmacy")
@Getter
@Setter
@NoArgsConstructor
public class RecipeMedicineEntity implements Serializable {

    @Id
    @Column(name = "id_rm")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_reteta")
    private RecipeEntity reteta;

    @ManyToOne
    @JoinColumn(name = "id_medicament")
    private MedicineEntity medicament;

    @Column(name = "numar_medicamente")
    private Integer numarMedicamente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeMedicineEntity that = (RecipeMedicineEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RecipeMedicineEntity{" +
                "id=" + id +
                ", reteta=" + reteta +
                ", medicament=" + medicament +
                ", numarMedicamente=" + numarMedicamente +
                '}';
    }
}
