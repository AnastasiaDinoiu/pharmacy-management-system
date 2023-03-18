-- Crearea tabelului POSTURI
CREATE TABLE posturi (
                         id_post INT NOT NULL AUTO_INCREMENT,
                         CONSTRAINT POST_id_post_PK PRIMARY KEY (id_post),
                         denumire_post VARCHAR(20) NOT NULL,
                         CONSTRAINT POST_den_post_UK UNIQUE (denumire_post),
                         salariu DECIMAL(4, 0) NOT NULL,
                         CONSTRAINT POST_salariu_C CHECK (salariu > 1525)
);