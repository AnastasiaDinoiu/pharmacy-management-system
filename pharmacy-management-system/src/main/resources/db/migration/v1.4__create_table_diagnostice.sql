-- Crearea tabelului DIAGNOSTICE
CREATE TABLE diagnostice (
                             cod_diagnostic INT NOT NULL AUTO_INCREMENT,
                             CONSTRAINT DIAG_cod_diag_PK PRIMARY KEY(cod_diagnostic),
                             denumire_diagnostic VARCHAR(100) NOT NULL,
                             CONSTRAINT DIAG_den_diag_UK UNIQUE (denumire_diagnostic)
);