-- Crearea tabelului MEDICI_PRESCRIPTORI
CREATE TABLE medici_prescriptori (
                                     parafa_medic_prescriptor INT NOT NULL AUTO_INCREMENT,
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