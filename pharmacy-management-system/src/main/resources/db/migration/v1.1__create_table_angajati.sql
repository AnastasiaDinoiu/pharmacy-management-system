-- Crearea tabelului ANGAJATI
CREATE TABLE angajati (
                          id_angajat INT NOT NULL AUTO_INCREMENT,
                          CONSTRAINT ANG_id_ang_PK PRIMARY KEY (id_angajat),
                          nume VARCHAR(20)  NOT NULL,
                          prenume VARCHAR(30) NOT NULL,
                          cnp DECIMAL(13, 0) NOT NULL,
                          CONSTRAINT ANG_cnp_UK UNIQUE (cnp),
                          CONSTRAINT ANG_cnp_C CHECK (LENGTH(cnp)=13),
                          id_post INT,
                          CONSTRAINT ANG_id_post_FK FOREIGN KEY (id_post) REFERENCES posturi (id_post) ON DELETE SET NULL,
                          email VARCHAR(30) NOT NULL,
                          CONSTRAINT ANG_email_UK UNIQUE (email),
                          telefon VARCHAR(10) NOT NULL,
                          CONSTRAINT ANG_telefon_UK UNIQUE (telefon),
                          CONSTRAINT ANG_telefon_C CHECK (LENGTH(telefon)=10)
);