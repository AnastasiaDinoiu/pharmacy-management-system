-- Crearea tabelului MEDICI_PRESCRIPTORI
CREATE TABLE MEDICI_PRESCRIPTORI (
                                     parafa_medic_prescriptor DECIMAL(5, 0),
                                     CONSTRAINT MEDP_par_medp_PK PRIMARY KEY (parafa_medic_prescriptor),
                                     unitate_medicala VARCHAR(50) NOT NULL,
                                     nume VARCHAR(20) NOT NULL,
                                     prenume VARCHAR(30) NOT NULL,
                                     email VARCHAR(30) NOT NULL,
                                     CONSTRAINT MEDP_email_UK UNIQUE (email),
                                     telefon VARCHAR(10) NOT NULL,
                                     CONSTRAINT MEDP_telefon_UK UNIQUE (telefon),
                                     CONSTRAINT MEDP_telefon_C CHECK (LENGTH(telefon)=10)
);