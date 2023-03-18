//package com.bdproject.pharmacy.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//@Getter
//@Setter
//public class RecipeMedicineId implements Serializable {
//
//    @Column(name = "id_reteta")
//    private Integer idReteta;
//
//    @Column(name = "id_medicament")
//    private Integer idMedicament;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RecipeMedicineId that = (RecipeMedicineId) o;
//        return Objects.equals(idReteta, that.idReteta) && Objects.equals(idMedicament, that.idMedicament);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idReteta, idMedicament);
//    }
//}
