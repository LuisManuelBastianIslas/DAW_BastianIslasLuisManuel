insert into tipoMateria(nombreTipoMateria)
values
('Teórica'),
('Práctica'),
('Otro'),
('Teórica/Práctica'),
('Teórica/Otro'),
('Teórica/Otro'),
('Práctica/Otro'),
('Teorica/Práctica/Otro');

insert into tipoContrato(nombreTipoContrato)
values
('Planta'),
('Tiempo Completo'),
('Medio Tiempo'),
('Cátedra');

insert into tipoCarrera(nombreTipoCarrera)
values
('Ingenieria'),
('Licenciatura');

insert into tipoEstudio(nombreTipoEstudio)
values
('Profesional'),
('Especialización'),
('Maestría'),
('Doctorado'),
('Seminario'),
('Diplimado');

insert into tipoSalon(nombreTipoSalon)
values
('Salon'),
('Laboratorio de computo'),
('Laboratorio quimico'),
('Laboratorio mecanico');

insert into estatusCurso(nombreEstatusCurso)
values
('Pendiente'),
('En curso'),
('Finalizado'),
('Terminado');

insert into estatusAlumno(nombreEstatusAlumno)
values
('Activo'),
('Graduado'),
('Suspendido'),
('Baja'),
('Expulsado');

insert into estatusCursoAlumno(nombreEstatusCursoAlumno)
values
('En curso'),
('Aprovado'),
('No aprovado'),
('Baja'),
('Terminado');

insert into materia(idMateria, nombreMateria, creditos, horas, idTipoMateria)
values
(1101, 'Lectura y escritura de textos academicos', 4, 4, 3),	-- 2 de "AFBG"
(1201, 'Literacidad Digital', 4, 6, 3),
(2101, 'Fisica', 8, 5, 4),										-- 2 de Iniciacion a la disciplina
(2201, 'Introducción a la programación', 8, 5, 4),
(3101, 'Programación estructurada', 7, 5, 4),					-- 2 de Formacion Disciplinar
(3201, 'Técnicas de medición', 8, 5, 4),
(3301, 'Estructura de datos', 8, 5, 4),							-- 2 de Informatica
(3401, 'Fundamentos de redes de computadoras', 6, 4, 4),
(3502, 'Mecanismos', 6, 4, 4),									-- 2 de Mecatronica
(3601, 'Dinamica', 6, 4, 4);

insert into profesor(curp, nombre, apellidoMaterno, apellidoPaterno, direccion, genero, telefono, fechaNacimiento, celular, email, idProfesor, idTipoContrato)
values
('GAHA840514MVZRRNXX','Ana María','García','Hernández','Av. Las Palmas #23, Veracruz, Ver.','F','2291848667','1984-05-14','2291757131','anamaríagarcía@bastianuniversities.mx', 'P001',3),
('LORJ731004HVZPZNXX','Juan Carlos','López','Ruiz','Calle 20 de Noviembre #45, Boca del Río, Ver.','M','2295931226','1973-10-04','2290435568','juancarloslópez@bastianuniversities.mx', 'P002', 2),
('GOGM850117MVZNNRXX','María Fernanda','González','González','Fracc. Las Brisas #8, Veracruz, Ver.','F','2296674064','1985-01-17','2290879048','maríafernandagonzález@bastianuniversities.mx', 'P003',4),
('HELC851105HVZRPRXX','Carlos Eduardo','Hernández','López','Col. San José #12, Boca del Río, Ver.','M','2294935957','1985-11-05','2296750487','carloseduardohernández@bastianuniversities.mx', 'P004',2),
('PEGS830607MVZRRFXX','Sofía Guadalupe','Pérez','García','Calle Miguel Alemán #56, Veracruz, Ver.','F','2295355287','1983-06-07','2297122342','sofíaguadalupepérez@bastianuniversities.mx', 'P005',3),
('RARF720227HVZMMRXX','Francisco Javier','Ramírez','Ramírez','Fracc. Costa de Oro #34, Boca del Río, Ver.','M','2294159785','1972-02-27','2294479421','franciscojavierramírez@bastianuniversities.mx', 'P006',4);

insert into carrera(idCarrera, nombreCarrera, idTipoCarrera, idProfesor)
values
(1, 'Informatica', 1, 'P006'),
(2, 'Mecatronica', 1, 'P001');

insert into alumno(curp, nombre, apellidoMaterno, apellidoPaterno, genero, fechaNacimiento, direccion, telefono, celular, email, matriculaAlumno, idCarrera, anoInscripcion, idEstatusAlumno, idProfesor)
values
('MARA020226FVZRDNXX','Andrea Isabel','Martínez','Rodríguez','F','2002-02-26','Av. Díaz Mirón #123, Veracruz, Ver.','2299247773','2295858892','eB200001@bastianuniversities.mx','B200001','1','2020','1','P002'),
('TOHJ010909MVZRRNXX','Juan Antonio','Torres','Hernández','M','2001-09-09','Col. Progreso #67, Boca del Río, Ver.','2298879389','2295424305','eB200002@bastianuniversities.mx','B200002','2','2020','1','P005'),
('PERM020120FVZRMRXX','Mariana Alejandra','Pérez','Ramírez','F','2002-01-20','Fracc. El Dorado #9, Veracruz, Ver.','2293023852','2295643312','eB200003@bastianuniversities.mx','B200003','1','2020','1','P002'),
('GOPL020201MVZNRSXX','Luis Miguel','González','Pérez','M','2002-02-01','Calle 16 de Septiembre #87, Boca del Río, Ver.','2296754194','2293343720','eB200004@bastianuniversities.mx','B200004','2','2020','1','P005'),
('SEGD020720FVZNMNXX','Daniela','Sánchez','Gómez','F','2002-07-20','Av. Ruiz Cortines #54, Veracruz, Ver.','2298930812','2291974570','eB200005@bastianuniversities.mx','B200005','1','2020','1','P004'),
('ROGJ031012MVZDRSXX','José Manuel','Rodríguez','García','M','2003-10-12','Col. Ricardo Flores Magón #23, Boca del Río, Ver.','2299932065','2297686695','eB200006@bastianuniversities.mx','B200006','2','2020','1','P003'),
('TORP030623FVZRMLXX','Paola Alejandra','Torres','Romero','F','2003-06-23','Fracc. Costa Verde #14, Veracruz, Ver.','2291158867','2297048085','eB210001@bastianuniversities.mx','B210001','1','2021','1','P003'),
('GUPR030507MVZTRBXX','Roberto Carlos','Gutiérrez','Pérez','M','2003-05-07','Calle Orizaba #34, Boca del Río, Ver.','2296343147','2291924352','eB210002@bastianuniversities.mx','B210002','2','2021','1','P003'),
('ROHG030605FVZDRBXX','Gabriela','Rodríguez','Hernández','F','2003-06-05','Col. Playa Linda #56, Veracruz, Ver.','2296559634','2291543691','eB210003@bastianuniversities.mx','B210003','1','2021','1','P002'),
('MEFM030205MVZNLGXX','Miguel Ángel','Méndez','Flores','M','2003-02-05','Fracc. Lomas de Río Medio #8, Boca del Río, Ver.','2292418467','2296177107','eB210004@bastianuniversities.mx','B210004','2','2021','1','P003'),
('GAML040817FVZRNRXX','Laura Elizabeth','García','Méndez','F','2004-08-17','Calle Álamo #23, Veracruz, Ver.','2298939512','2296481301','eB210005@bastianuniversities.mx','B210005','1','2021','1','P002'),
('HETJ030730MVZRRNXX','Juan Francisco','Hernández','Torres','M','2003-07-30','Col. Mocambo #67, Boca del Río, Ver.','2295351945','2299922784','eB210006@bastianuniversities.mx','B210006','2','2021','1','P004'),
('RALD050831FVZMPNXX','Diana Paola','Ramos','López','F','2005-08-31','Fracc. Jardines de Virginia #9, Veracruz, Ver.','2295050148','2299424254','eB220001@bastianuniversities.mx','B220001','1','2022','1','P002'),
('TOMF040123MVZRRRXX','Fernando José','Torres','Martínez','M','2004-01-23','Calle Reforma #87, Boca del Río, Ver.','2291465033','2292867532','eB220002@bastianuniversities.mx','B220002','2','2022','1','P003'),
('AURM040421FVZGVLXX','Melissa Guadalupe','Aguilar','Rivera','F','2004-04-21','Col. Reforma #54, Veracruz, Ver.','2291428375','2297881312','eB220003@bastianuniversities.mx','B220003','1','2022','1','P001'),
('VAGS040226MVZRNLXX','Salvador Arturo','Vargas','González','M','2004-02-26','Fracc. Jardines del Virginia #23, Boca del Río, Ver.','2296421417','2293824520','eB220004@bastianuniversities.mx','B220004','2','2022','1','P005'),
('TOGE040106FVZRRSXX','Estefanía','Torres','García','F','2004-01-06','Calle Xalapa #67, Veracruz, Ver.','2291175163','2295430825','eB220005@bastianuniversities.mx','B220005','1','2022','1','P005'),
('ROTC041122MVZDRRXX','Carlos Eduardo','Rodríguez','Torres','M','2004-11-22','Col. Carranza #14, Boca del Río, Ver.','2294229841','2298548733','eB220006@bastianuniversities.mx','B220006','2','2022','1','P006');

insert into asignatura(nrc, idMateria, idProfesor, cupoMinimo, cupoMaximo)
values
-- NRC : idCarrera + periodo (Ene-Jun -> 1 | Jul-Dic -> 2) + idMateria
-- Diferente NRC para separar a Informatica y Mecatronica aun y cuando es la misma materia
(111101, 1101),	-- 6 de Informatica
(111201, 1201),
(122101, 2101),
(122201, 2201),
(113101, 3101),
(113201, 3201),
(211101, 1101),	-- 6 de Mecatronica
(211201, 1201),
(222101, 2101),
(222201, 2201),
(213101, 3101),
(213201, 3201),
(123301, 3301),							-- 2 de Informatica
(123401, 3401),
(223502, 3502),									-- 2 de Mecatronica
(223601, 3601);

insert into salon(idSalon, idTipoSalon, ubicacion, cantidadPupitres)
values
('A01', 1, 'Edificio A', 7),
('A02', 1, 'Edificio A', 7),
('A03', 3, 'Edificio A', 6),
('A04', 4, 'Edificio A', 6),
('B01', 2, 'Edificio B', 5),
('B02', 2, 'Edificio B', 5),
('B03', 2, 'Edificio B', 5);

--insert into curso(periodo, nrc, idEstatusCurso)
--values
--;

insert into requicitoMateria(idMateria, idMateriaRequicito)
values
(3101, 2201),
(3301, 3101),
(3502, 3601);

--insert into estudio(curp, universidad, titulo, cedula, anoGraduacion, idTipoEstudio)
--values
--;

insert into materiaProfesor(idProfesor, idMateria)
values
('P001', 1101),	-- Lectura
('P002', 2101),	-- Fisica
('P003', 1201),	-- Lit digital
('P003', 2101),	-- Tecnicas med
('P003', 2201),	-- Intro prog
('P004', 2201),	-- Intro prog
('P004', 3101),	-- Prog estruct
('P004', 3301),	-- Estruct datos
('P005', 3502),	-- Mecanismos
('P005', 2101),	-- Tecnicas med
('P005', 3601),	-- Dinamica
('P006', 3401);	-- Intro redes

insert into materiaCarrera(idMateria, idCarrera, semestre)
values
(1101, 1, 1),
(1101, 2, 1),
(1201, 1, 2),
(1201, 2, 2),
(2101, 1, 3),
(2101, 2, 3),
(2201, 1, 4),
(2201, 2, 4),
(3101, 1, 5),
(3101, 2, 5),
(3201, 1, 6),
(3201, 2, 6),
(3301, 1, 8),
(3401, 1, 7),
(3502, 2, 7),
(3601, 2, 8);

--insert into cursoSalon(periodo, nrc, idSalon, hora, diaSemana)
--values

-- into cursoAlumno(matriculaAlumno, periodo, nrc, idEstatusCursoAlumno, calificacion)
--values

--insert into incidencias(matriculaAlumno, periodo, nrc, fecha, incidencia)
--values

insert into administrador(usuarioAdministrador, nombreAdministrador)
values
('amdin', 'Administrador');

insert into loginProfesor(idProfesor, contraseñaLoginProfesor, estatusLoginProfesor)
values
('P001', 'password', 1),
('P002', 'password', 1),
('P003', 'password', 1),
('P004', 'password', 1),
('P005', 'password', 1),
('P006', 'password', 1);

insert into loginAlumno(matriculaAlumno, contraseñaLoginAlumno, estatusLoginAlumno)
values
('B200001', 'password', 1),
('B200002', 'password', 1),
('B200003', 'password', 1),
('B200004', 'password', 1),
('B200005', 'password', 1),
('B200006', 'password', 1),
('B210001', 'password', 1),
('B210002', 'password', 1),
('B210003', 'password', 1),
('B210004', 'password', 1),
('B210005', 'password', 1),
('B210006', 'password', 1),
('B220001', 'password', 1),
('B220002', 'password', 1),
('B220003', 'password', 1),
('B220004', 'password', 1),
('B220005', 'password', 1),
('B220006', 'password', 1);

insert into loginAdministrador(usuarioAdministrador, contraseñaLoginAdministrador, estatusLoginAdministrador)
values
('admin', 'admin', 1);