package com.bdproject.pharmacy.dto.request;

import lombok.Getter;

@Getter
public class EmployeeRequest {

    private String nume;
    private String prenume;
    private Long cnp;
    private Integer idPost;
    private String email;
    private String telefon;
}
