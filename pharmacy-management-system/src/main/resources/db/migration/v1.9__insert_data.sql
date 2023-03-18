-- Inserarea datelor in tabelul POSTURI
INSERT INTO posturi (id_post, denumire_post, salariu) VALUES (1, 'Farmacist sef', 5000);
INSERT INTO posturi (id_post, denumire_post, salariu) VALUES (2, 'Farmacist', 3500);
INSERT INTO posturi (id_post, denumire_post, salariu) VALUES (3, 'Asistent', 2300);
INSERT INTO posturi (id_post, denumire_post, salariu) VALUES (4, 'Ingrijitor', 1800);
INSERT INTO posturi (id_post, denumire_post, salariu) VALUES (5, 'Agent de paza', 1800);

-- Inserarea datelor in tabelul ANGAJATI
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (1, 'Cantemir', 'Ioana', '2900112416125', 1, 'icantemir@gmail.com', '0767781869');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (2, 'Dumitrescu', 'Stefan', '2900908416467', 2, 'sdumitrescu@gmail.com', '0768391749');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (3, 'Popescu', 'Lucia', '2880902419651', 2, 'lpopescu@gmail.com', '0760945166');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (4, 'Stoica', 'Mariana', '2910904418185', 2, 'mstoica@gmail.com', '0769180843');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (5, 'Munteanu', 'Andrada', '2910904419312', 3, 'amunteanu@gmail.com', '0725473119');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (6, 'Serban', 'Laurentiu', '2910905415940', 3, 'lserban@gmail.com', '0721427665');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (7, 'Toma', 'Andreea', '2910905415174', 3, 'atoma@gmail.com', '0723929887');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (8, 'Lazar', 'Florentina', '2910905418997', 3, 'flazar@gmail.com', '0724969576');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (9, 'Florea', 'Liliana', '2770422416169', 3, 'lflorea@gmail.com', '0721443546');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (10, 'Tudor', 'Cornelia', '2770422415951', 4, 'ctudor@gmail.com', '0728844502');
INSERT INTO angajati (id_angajat, nume, prenume, cnp, id_post, email, telefon) VALUES (11, 'Dragomir', 'Alexandru', '2810409418360', 5, 'adragomir@gmail.com', '0729497262');

-- Inserarea datelor in tabelul PACIENTI
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (1, 'Vlad', 'Marina', '2910401438968');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (2, 'Iordache', 'Larisa', '2910402096305');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (3, 'Ion', 'Ciprian', '1930402409522');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (4, 'Tanase', 'Laura', '2910403408726');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (5, 'Craciun', 'Larisa', '2910404408181');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (6, 'Cojocaru', 'Coralia', '2910404405037');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (7, 'Mocanu', 'Dragos', '1790609157692');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (8, 'Enache', 'Alexandra', '2910406408716');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (9, 'Petre', 'Mihaela', '2910407406985');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (10, 'Balan', 'Marius', '5000613219032');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (11, 'Zaharia', 'Beatrice', '2740314297874');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (12, 'Vlaicu', 'Daniel', '1780220297104');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (13, 'Soroiu', 'Claudiu', '1871230296000');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (14, 'Tudor', 'Petre', '1940914298895');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (15, 'Vasilescu', 'Natalia', '2700923295311');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (16, 'Olaru', 'Iulian', '1901010296888');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (17, 'Gheorghe', 'Aurel', '1900531109972');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (18, 'Rotaru', 'Raluca', '2710802296453');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (19, 'Nistor', 'Magdalena', '2780706297396');
INSERT INTO pacienti (id_pacient, nume, prenume, cnp) VALUES (20, 'Pirvu', 'Florin', '1810422155192');

-- Inserarea datelor in tabelul MEDICI_PRESCRIPTORI
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (1, 'CMI DR. Suciu Georgeta', 'Suciu', 'Georgeta', 'gsuciu@gmail.com', '0712088686');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (2, 'CMI DR. Marin Eugen', 'Marin', 'Eugen', 'emarin@gmail.com', '0724757789');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (3, 'CMI DR. Ionescu Viorel', 'Ionescu', 'Viorel', 'vionescu@gmail.com', '0718186848');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (4, 'CMI DR. Munteanu Elena', 'Munteanu', 'Elena', 'emunteanu@gmail.com', '0759202683');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (5, 'CMI DR. Rizea Valeria', 'Rizea', 'Valeria', 'vrizea@gmail.com', '0716042906');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (6, 'CMI DR. Vasilescu Mircea', 'Vasilescu', 'Mircea', 'mvasilescu@gmail.com', '0764503217');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (7, 'CMI DR. Angelescu Nicolae', 'Angelescu', 'Nicolae', 'nangelescu@gmail.com', '0761896282');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (8, 'CMI DR. Bratu Zamfir', 'Bratu', 'Zamfir', 'zbratu@gmail.com', '0742163884');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (9, 'CMI DR. Dumitrescu Vasile', 'Dumitrescu', 'Vasile', 'vdumitrescu@gmail.com', '0748939352');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (10, 'CMI DR. Cristache Razvan', 'Cristache', 'Razvan', 'rcristache@gmail.com', '0758005924');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (11, 'CMI DR. Andronache Paula', 'Andronache', 'Paula', 'pandronache@gmail.com', '0761434518');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (12, 'CMI DR. Mircescu Alexandru', 'Mircescu', 'Alexandru', 'amircescu@gmail.com', '0752215534');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (13, 'CMI DR. Popescu Mirela', 'Popescu', 'Mirela', 'mpopescu@gmail.com', '0713492983');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (14, 'CMI DR. Verzea Teodora', 'Verzea', 'Teodora', 'tverzea@gmail.com', '0786207245');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (15, 'CMI DR. Mateescu Otilia', 'Mateescu', 'Otilia', 'omateescu@gmail.com', '0760604664');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (16, 'CMI DR. Lungu Doina', 'Lungu', 'Doina', 'dlungu@gmail.com', '0740602510');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (17, 'CMI DR. Alexandrescu Gabriela', 'Alexandrescu', 'Gabriela', 'galexandrescu@gmail.com', '0787816686');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (18, 'CMI DR. Dobre Emilia', 'Dobre', 'Emilia', 'edobre@gmail.com', '0749524115');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (19, 'CMI DR. Soare Dorina', 'Soare', 'Dorina', 'dsoare@gmail.com', '0766233499');
INSERT INTO medici_prescriptori (parafa_medic_prescriptor, unitate_medicala, nume, prenume, email, telefon) VALUES (20, 'CMI DR. Gherghe Cristian', 'Gherghe', 'Cristian', 'cgherghe@gmail.com', '0718181425');

-- Inserarea datelor in tabelul DIAGNOSTICE
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (1, 'Gastrita si duodenita');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (2, 'Dispepsia');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (3, 'Hipertensiunea esentiala (primara)');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (4, 'Fibroza si ciroza ficatului');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (5, 'Vene varicoase ale membrelor inferioare');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (6, 'Infectii acute ale cailor respiratorii superioare cu localizari multiple si neprecizate');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (7, 'Alte boli pulmonare obstructive cronice');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (8, 'Embolia si tromboza arteriala');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (9, 'Embolia si tromboza venoasa');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (10, 'Alte spondilopatii');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (11, 'Tulburari de metabolism al lipoproteinelor si alte lipidemii');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (12, 'Alte leucemii cu celule precizate');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (13, 'Diabetul zaharat neinsulino-dependent');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (14, 'Hiperplazia prostatei');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (15, 'Alte boli cerebrovasculare');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (16, 'Endometrioza');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (17, 'Microcefalia');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (18, 'Sindromul Turner');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (19, 'Leziunea traumatica a nervilor');
INSERT INTO diagnostice (cod_diagnostic, denumire_diagnostic) VALUES (20, 'Rujeola');


-- Inserarea datelor in tabelul RETETE
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (1, 1, 1, 'subacut', 1, '2022-01-03', 1);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (2, 1, 2, 'subacut', 1, '2022-01-03', 1);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (3, 2, 3, 'cronic', 2, '2022-01-03', 2);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (4, 3, 4, 'cronic', 3, '2022-01-04', 3);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (5, 4, 5, 'cronic', 4, '2022-01-04', 7);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (6, 5, 6, 'acut', 5, '2022-01-05', 4);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (7, 6, 7, 'acut', 6, '2022-01-06', 5);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (8, 7, 3, 'cronic', 7, '2022-01-07', 6);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (9, 8, 8, 'cronic', 8, '2022-01-10', 9);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (10, 9, 9, 'cronic', 9, '2022-01-11', 2);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (11, 10, 10, 'cronic', 10, '2022-01-12', 9);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (12, 11, 11, 'cronic', 11, '2022-01-12', 8);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (13, 12, 12, 'cronic', 12, '2022-01-13', 7);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (14, 13, 13, 'cronic', 13, '2022-01-14', 5);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (15, 14, 13, 'cronic', 14, '2022-01-14', 4);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (16, 15, 3, 'cronic', 15, '2022-01-17', 3);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (17, 16, 14, 'cronic', 16, '2022-01-18', 8);
INSERT INTO retete (id_reteta, id_pacient, cod_diagnostic, tip_tratament, parafa_medic_prescriptor, data_prescriere, id_angajat) VALUES (18, 17, 15, 'cronic', 17, '2022-01-18', 6);

-- Inserarea datelor in tabelul PRODUCATORI
INSERT INTO producatori (id_producator, producator, tara) VALUES (1, 'ASTRAZENECA AB', 'Suedia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (2, 'TERAPIA S.A.', 'Romania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (3, 'BERLIN - CHEMIE AG', 'Germania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (4, 'LES LABORATOIRES SERVIER INDUSTRIE (LSI)', 'Franta');
INSERT INTO producatori (id_producator, producator, tara) VALUES (5, 'MEDIS INTERNATIONAL A.S', 'Republica Ceha');
INSERT INTO producatori (id_producator, producator, tara) VALUES (6, 'ALFASIGMA S.P.A.', 'Italia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (7, 'ZENTIVA, K.S', 'Republica Ceha');
INSERT INTO producatori (id_producator, producator, tara) VALUES (8, 'THEA FARMA S.P.A.', 'Italia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (9, 'ANGELINI PHARMA CESKÁ REPUBLICA S.R.O.', 'Republica Ceha');
INSERT INTO producatori (id_producator, producator, tara) VALUES (10, 'ALKALOID-INT D.O.O.', 'Slovenia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (11, 'BRISTOL-MYERS SQUIBB SRL', 'Italia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (12, 'BAYER AG', 'Germania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (13, 'UPJOHN EESV', 'Olanda');
INSERT INTO producatori (id_producator, producator, tara) VALUES (14, 'KRKA, D.D., NOVO MESTO', 'Slovenia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (15, 'PFIZER MANUFACTURING DEUTSCHLAND GMBH', 'Germania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (16, 'NOVARTIS PHARMA GMBH', 'Germania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (17, 'NOVO NORDISK A/S', 'Danemarca');
INSERT INTO producatori (id_producator, producator, tara) VALUES (18, 'GLAXOSMITHKLINE PHARMACEUTICALS S.A.', 'Polonia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (19, 'ATREIZA LABORATORIOS, SL', 'Spania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (20, 'LILLY S.A.', 'Spania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (21, 'ELI LILLY ITALIA SPA', 'Italia');
INSERT INTO producatori (id_producator, producator, tara) VALUES (22, 'SANOFI - AVENTIS DEUTSCHLAND GMBH', 'Germania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (23, 'AMW GMBH ARZNEIMITTELWERK WARNGAU', 'Germania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (24, 'ASTELLAS PHARMA EUROPE B.V.', 'Olanda');
INSERT INTO producatori (id_producator, producator, tara) VALUES (25, 'ROCHE PHARMA AG', 'Germania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (26, 'ANTIBIOTICE SA', 'Romania');
INSERT INTO producatori (id_producator, producator, tara) VALUES (27, 'ALK-ABELLÓ S.A. ', 'Spania');

-- Inserarea datelor in tabelul MEDICAMENTE
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (1, 'ESOMEPRAZOLUM', 'NEXIUM', 'COMPR. GASTROREZISTENTE', '40mg', 1);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (2, 'DOMPERIDONUM', 'MOTILIUM', 'COMPR. FILM.', '10mg', 2);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (3, 'NEBIVOLOLUM', 'NEBILET', 'COMPR.', '5mg', 3);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (4, 'COMBINATII (PERINDOPRILUM+INDAPAMIDUM)', 'NOLIPREL ARG', 'COMPR. FILM.', '2,5mg/0,625mg', 4);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (5, 'FUROSEMIDUM', 'FUROSEMID MEDREG', 'COMPR.', '40mg', 5);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (6, 'ESOMEPRAZOLUM', 'ESOMEPRAZOL TERAPIA', 'CAPS. GASTROREZ.', '40mg', 2);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (7, 'SULODEXIDUM', 'VESSEL DUE F', 'CAPS. MOI', '250ULS', 6);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (8, 'IBUPROFENUM', 'ALGIN', 'SUSP. ORALA', '100mg/5ml', 7);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (9, 'COMBINATII (BETAMETHASONUM+TETRYZOLINUM)', 'BIORINIL', 'SPRAY NAZ.,SUSP.', '0,5mg/1mg/ml', 8);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (10, 'ERDOSTEINUM', 'ERDOMED', 'CAPS.', '300mg', 9);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (11, 'CEFIXIMUM', 'XIFIA', 'COMPR. FILM.', '400mg', 10);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (12, 'TELMISARTANUM', 'TEZEO', 'COMPR.', '80mg', 7);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (13, 'APIXABANUM', 'ELIQUIS', 'COMPR. FILM.', '5 mg', 11);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (14, 'RIVAROXABANUM', 'XARELTO', 'COMPR. FILM.', '20mg', 12);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (15, 'PREGABALINUM', 'LYRICA', 'CAPS.', '75mg', 13);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (16, 'COMBINATII (TRAMADOLUM+PARACETAMOLUM)', 'DORETA', 'COMPR. FILM.', '37,5mg/325mg', 14);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (17, 'ATORVASTATINUM', 'SORTIS', 'COMPR. FILM.', '20mg', 15);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (18, 'RUXOLITINIBUM', 'JAKAVI', 'COMPR.', '20mg', 16);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (19, 'METFORMINUM', 'SIOFOR', 'COMPR. FILM.', '1000mg', 3);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (20, 'SEMAGLUTIDUM', 'OZEMPIC', 'SOL. INJ. IN STILOU INJECTOR (PEN) PREUMPLUT', '1,34mg/ml', 17);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (21, 'AMLODIPINUM', 'NORVASC', 'COMPR.', '10mg', 15);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (22, 'TELMISARTANUM', 'TEZEO', 'COMPR.', '40mg', 7);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (23, 'DUTASTERIDUM', 'AVODART', 'CAPS. MOI', '0,5mg', 18);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (24, 'VINPOCETINUM', 'VINPOCETINA COVEX', 'COMPR.', '10mg', 19);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (25, 'ISOTRETINOINUM', 'SOTRET', 'CAPS. MOI', '10mg', 2);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (26, 'ABEMACICLIBUM', 'VERZENIOS', 'COMPR. FILM.', '100mg', 20);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (27, 'DULAGLUTIDUM', 'TRULICITY', 'SOL INJ.', '0,75 mg/0,5ml', 21);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (28, 'COMBINATII (INSULINE GLARGINE+LIXISENATIDUM)', 'SULIQUA ', 'SOL INJ. IN STILOU INJECTOR (PEN) PREUMPLUT', '100unitati/ml+33micrograme/ml', 22);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (29, 'GOSERELINUM', 'RESELIGO', 'IMPLANT IN SERINGA PREUMPLUTA', '10,8mg', 23);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (30, 'LEUPRORELINUM', 'ELIGARD', 'PULB+SOLV. PT. SOL. INJ.', '22,5mg', 24);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (31, 'EPOETINUM BETA', 'NEORECORMON', 'SOL. INJ. IN SERINGA PREUMPLUTA', '2000UI/0,3ml', 25);
INSERT INTO medicamente (id_medicament, dci, denumire_comerciala, forma_farmaceutica, concentratie, id_producator) VALUES (32, 'LIRAGLUTIDUM', 'VICTOZA', 'SOL. INJ. IN STILOU INJECTOR PREUMPLUT', '6 mg/ml', 17);

-- Inserarea datelor in tabelul RETETE_MEDICAMENTE
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (1, 1, 1, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (2, 2, 2, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (3, 3, 3, 2);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (4, 3, 4, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (5, 4, 5, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (6, 4, 6, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (7, 5, 7, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (8, 6, 8, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (9, 6, 9, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (10, 7, 10, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (11, 7, 11, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (12, 8, 12, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (13, 9, 13, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (14, 10, 14, 2);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (15, 11, 15, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (16, 11, 16, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (17, 12, 17, 2);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (18, 13, 18, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (19, 14, 19, 2);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (20, 15, 20, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (21, 16, 21, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (22, 17, 23, 1);
INSERT INTO retete_medicamente (id_rm, id_reteta, id_medicament, numar_medicamente) VALUES (23, 18, 24, 2);