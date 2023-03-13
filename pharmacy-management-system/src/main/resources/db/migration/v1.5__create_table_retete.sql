-- Crearea tabelului RETETE
CREATE TABLE RETETE (
                        id_reteta DECIMAL(5, 0),
                        CONSTRAINT RET_id_ret_PK PRIMARY KEY(id_reteta),
                        id_pacient DECIMAL(5, 0) NOT NULL,
                        CONSTRAINT RET_id_pacient_FK FOREIGN KEY(id_pacient) REFERENCES PACIENTI(id_pacient) ON DELETE CASCADE,
                        cod_diagnostic DECIMAL(5, 0) NOT NULL,
                        CONSTRAINT RET_cod_diag_FK FOREIGN KEY(cod_diagnostic) REFERENCES DIAGNOSTICE(cod_diagnostic) ON DELETE CASCADE,
                        tip_tratament VARCHAR(7) NOT NULL
                            CONSTRAINT RET_tip_trat_C CHECK (tip_tratament='acut' OR tip_tratament='subacut' OR tip_tratament='cronic'),
                        parafa_medic_prescriptor DECIMAL(5, 0)  NOT NULL,
                        CONSTRAINT RET_par_medp_FK FOREIGN KEY(parafa_medic_prescriptor) REFERENCES MEDICI_PRESCRIPTORI(parafa_medic_prescriptor) ON DELETE CASCADE,
                        data_prescriere DATE,
                        id_angajat DECIMAL(5, 0),
                        CONSTRAINT RET_id_ang_FK FOREIGN KEY(id_angajat) REFERENCES ANGAJATI(id_angajat) ON DELETE SET NULL
);