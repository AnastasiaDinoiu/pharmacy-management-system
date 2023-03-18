-- Crearea tabelului MEDICAMENTE
CREATE TABLE medicamente (
                             id_medicament INT,
                             CONSTRAINT MED_id_med_PK PRIMARY KEY(id_medicament),
                             dci VARCHAR(50) NOT NULL,
                             denumire_comerciala VARCHAR(30) NOT NULL,
                             forma_farmaceutica VARCHAR(50)  NOT NULL,
                             concentratie VARCHAR(30) NOT NULL,
                             id_producator INT,
                             CONSTRAINT MED_id_prod_FK FOREIGN KEY(id_producator) REFERENCES producatori(id_producator) ON DELETE SET NULL
);