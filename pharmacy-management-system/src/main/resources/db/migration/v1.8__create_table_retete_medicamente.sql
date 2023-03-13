-- Crearea tabelului RETETE_MEDICAMENTE
CREATE TABLE RETETE_MEDICAMENTE (
                                    id_reteta DECIMAL(5, 0),
                                    CONSTRAINT RMED_id_ret_FK FOREIGN KEY (id_reteta) REFERENCES RETETE(id_reteta) ON DELETE CASCADE,
                                    id_medicament DECIMAL(5, 0),
                                    CONSTRAINT RMED_id_med_FK FOREIGN KEY (id_medicament) REFERENCES MEDICAMENTE(id_medicament) ON DELETE CASCADE,
                                    numar_medicamente DECIMAL(5, 0) NOT NULL,
                                    CONSTRAINT RMED_PK PRIMARY KEY (id_reteta, id_medicament)
);