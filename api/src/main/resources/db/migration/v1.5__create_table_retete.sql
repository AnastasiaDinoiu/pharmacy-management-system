-- Crearea tabelului RETETE
CREATE TABLE retete (
                        id_reteta INT NOT NULL AUTO_INCREMENT,
                        CONSTRAINT RET_id_ret_PK PRIMARY KEY(id_reteta),
                        id_pacient INT NOT NULL,
                        CONSTRAINT RET_id_pacient_FK FOREIGN KEY(id_pacient) REFERENCES pacienti(id_pacient) ON DELETE CASCADE,
                        cod_diagnostic INT NOT NULL,
                        CONSTRAINT RET_cod_diag_FK FOREIGN KEY(cod_diagnostic) REFERENCES diagnostice(cod_diagnostic) ON DELETE CASCADE,
                        tip_tratament VARCHAR(7) NOT NULL
                            CONSTRAINT RET_tip_trat_C CHECK (tip_tratament='acut' OR tip_tratament='subacut' OR tip_tratament='cronic'),
                        parafa_medic_prescriptor INT NOT NULL,
                        CONSTRAINT RET_par_medp_FK FOREIGN KEY(parafa_medic_prescriptor) REFERENCES medici_prescriptori(parafa_medic_prescriptor) ON DELETE CASCADE,
                        data_prescriere DATE,
                        id_angajat INT,
                        CONSTRAINT RET_id_ang_FK FOREIGN KEY(id_angajat) REFERENCES angajati(id_angajat) ON DELETE SET NULL
);