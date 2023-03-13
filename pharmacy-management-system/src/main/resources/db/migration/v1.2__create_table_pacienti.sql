-- Crearea tabelului PACIENTI
CREATE TABLE pacienti (
                          id_pacient DECIMAL(5, 0),
                          CONSTRAINT PAC_id_pac_PK PRIMARY KEY (id_pacient),
                          nume VARCHAR(20) NOT NULL,
                          prenume VARCHAR(30) NOT NULL,
                          cnp DECIMAL(13, 0) NOT NULL,
                          CONSTRAINT PAC_cnp_UK UNIQUE (cnp),
                          CONSTRAINT PAC_cnp_C CHECK (LENGTH(cnp)=13)
);