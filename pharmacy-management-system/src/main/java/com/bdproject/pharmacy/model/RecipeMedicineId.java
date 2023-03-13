package com.bdproject.pharmacy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RecipeMedicineId implements Serializable {

    @Column(name = "id_reteta")
    private Integer idReteta;

    @Column(name = "id_medicament")
    private Integer idMedicament;
}
