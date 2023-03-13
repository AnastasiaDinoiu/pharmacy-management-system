-- Crearea tabelului PRODUCATORI
CREATE TABLE producatori (
                             id_producator DECIMAL(5, 0),
                             CONSTRAINT PROD_id_prod_PK PRIMARY KEY(id_producator),
                             producator VARCHAR(50) NOT NULL,
                             CONSTRAINT PROD_prod_UK UNIQUE(producator),
                             tara VARCHAR(20) NOT NULL
);