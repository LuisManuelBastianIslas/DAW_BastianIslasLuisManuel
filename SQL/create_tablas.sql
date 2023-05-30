-- create database DawCursosProject;

-- * Catalogos *
create table tipoMateria(
	idTipoMateria serial not null,
	nombreTipoMateria varchar(25),
	primary key (idTipoMateria)
);

create table tipoContrato(
	idTipoContrato serial not null,
	nombreTipoContrato varchar(15),
	primary key (idTipoContrato)
);

create table tipoCarrera(
	idTipoCarrera serial not null,
	nombreTipoCarrera varchar(15),
	primary key (idTipoCarrera)
);

create table tipoEstudio(
	idTipoEstudio serial not null,
	nombreTipoEstudio varchar(20),
	primary key (idTipoEstudio)
);

create table tipoSalon(
	idTipoSalon serial not null,
	nombreTipoSalon varchar(25),
	primary key (idTipoSalon)
);

create table estatusCurso(
	idEstatusCurso serial not null,
	nombreEstatusCurso varchar(15),
	primary key (idEstatusCurso)
);

create table estatusAlumno(
	idEstatusAlumno serial not null,
	nombreEstatusAlumno varchar(15),
	primary key (idEstatusAlumno)
);

create table estatusCursoAlumno(
	idEstatusCursoAlumno serial not null,
	nombreEstatusCursoAlumno varchar(15),
	primary key (idEstatusCursoAlumno)
);

create table genero(
	idGenero varchar(1),
	nombreGenero varchar(18),
	primary key (idGenero)
);

create table periodo(
	idPeriodo int,
	mesPerido int,
	descripcionPeriodo varchar(15),
	primary key (idPeriodo)
);

-- -------------
-- Entidad Padre
-- -------------

create table persona(
	curp varchar(18) not null unique,
	nombre text not null,
	apellidoMaterno text not null,
	apellidoPaterno text not null,
	idGenero varchar(1) not null,
	fechaNacimiento date not null,
	direccion text,
	telefono varchar(10),
	celular varchar(10),
	email text,
	primary key (curp),
	foreign key(idGenero) references genero(idGenero)
);

-- ---------
-- Entidades
-- ---------

create table materia(
	idMateria int not null unique,
	nombreMateria text not null,
	creditos int not null,
	horas int not null,
	idTipoMateria int not null,
	primary key (idMateria),
	foreign key (idTipoMateria) references tipoMateria(idTipoMateria)
);

create table profesor(
	idProfesor varchar(4) not null unique,
	idTipoContrato int not null,
	primary key (idProfesor),
	foreign key (idTipoContrato) references tipoContrato(idTipoContrato)
) inherits(persona);

create table carrera(
	idCarrera int not null unique,
	nombreCarrera varchar(45),
	idTipoCarrera int not null,
	idProfesor varchar(4),
	primary key (idCarrera),
	foreign key (idTipoCarrera) references tipoCarrera(idTipoCarrera),
	foreign key (idProfesor) references profesor(idProfesor)
);

create table alumno(
	matriculaAlumno varchar(7) unique,
	idCarrera int,
	anoInscripcion int,
	idEstatusAlumno int not null,
	idProfesor varchar(4),
	primary key (matriculaAlumno),
	foreign key (idCarrera) references carrera(idCarrera),
	foreign key (idEstatusAlumno) references estatusAlumno(idEstatusAlumno),
	foreign key (idProfesor) references profesor(idProfesor)
) inherits(persona);

create table asignatura(
	nrc int not null unique,
	idMateria int,
	idProfesor varchar(4),
	cupoMinimo int,
	cupoMaximo int,
	primary key (nrc),
	foreign key (idMateria) references materia(idMateria),
	foreign key (idProfesor) references profesor(idProfesor)
);

create table salon(
	idSalon varchar(3),
	idTipoSalon int not null,
	ubicacion varchar(20),
	cantidadPupitres int not null,
	primary key (idSalon),
	foreign key (idTipoSalon) references tipoSalon(idTipoSalon)
);

create table curso(
	idPeriodo int not null,
	nrc int not null,
	idEstatusCurso int not null,
	foreign key (idPeriodo) references periodo(idPeriodo),
	primary key (idPeriodo, nrc),
	foreign key (nrc) references asignatura(nrc),
	foreign key (idEstatusCurso) references estatusCurso(idEstatusCurso)
);

-- * Tablas que no considero entidades como tal porque no tienen un ID *
-- * Tablas de relacion, entidades debiles, etc
create table requicitoMateria(
	idMateria int not null,
	idMateriaRequicito int not null,
	foreign key (idMateria) references materia(idMateria),
	foreign key (idMateriaRequicito) references materia(idMateria)
);

create table estudio(
	curp varchar(18) not null,
	universidad text,
	titulo text,
	cedula varchar(7),
	anoGraduacion int,
	idTipoEstudio int not null,
	foreign key (curp) references persona(curp),
	foreign key (idTipoEstudio) references tipoEstudio(idTipoEstudio)
);

create table materiaProfesor(
	idProfesor varchar(4) not null,
	idMateria int not null,
	foreign key (idProfesor) references profesor(idProfesor),
	foreign key (idMateria) references materia(idMateria)
);

create table materiaCarrera(
	idMateria int not null,
	idCarrera int not null,
	semestre int not null,
	foreign key (idMateria) references materia(idMateria),
	foreign key (idCarrera) references carrera(idCarrera)
);

create table cursoSalon(
	idPeriodo int not null,
	nrc int not null,
	idSalon varchar(3) not null,
	hora int not null,
	diaSemana int not null,
	foreign key (idPeriodo, nrc) references curso(idPeriodo, nrc),
	foreign key (idSalon) references salon(idSalon)
);

create table cursoAlumno(	-- De esta se saca el cardex
	matriculaAlumno varchar(7) not null,
	periodo int not null,
	nrc int not null,
	idEstatusCursoAlumno int not null,
	calificacion int,
	foreign key (matriculaAlumno) references alumno(matriculaAlumno),
	foreign key (periodo, nrc) references curso(idPeriodo, nrc),
	foreign key (idEstatusCursoAlumno) references estatusCursoAlumno(idEstatusCursoAlumno)
);

create table incidencias(
	matriculaAlumno varchar(7) not null,
	idPeriodo int not null,
	nrc int not null,
	fecha date not null,
	incidencia text not null,
	foreign key (matriculaAlumno) references alumno(matriculaAlumno),
	foreign key (idPeriodo, nrc) references curso(idPeriodo, nrc)
);

-- ---------------------------------------------------------
-- Casi al final una tabla de administradores sin conexion a
-- nada porque harán todo desde los Servlets y JSPs
-- ---------------------------------------------------------
create table administrador(
	usuarioAdministrador text not null,
	nombreAdministrador text not null,
	primary key (usuarioAdministrador)
);
-- Al final los logins de manera muy arcaica
create table loginProfesor(
	idProfesor varchar(4) not null,
	contraseñaLoginProfesor text not null,
	estatusLoginProfesor int not null,
	foreign key (idProfesor) references profesor(idProfesor)
);

create table loginAlumno(
	matriculaAlumno varchar(7) not null,
	contraseñaLoginAlumno text not null,
	estatusLoginAlumno int not null,
	foreign key (matriculaAlumno) references alumno(matriculaAlumno)
);

create table loginAdministrador(
	usuarioAdministrador text not null,
	contraseñaLoginAdministrador text not null,
	estatusLoginAdministrador int not null,
	foreign key (usuarioAdministrador) references administrador(usuarioAdministrador)
);

-- ---------------------------------------------------
-- Finalmente, la tabla para gestionar el curso actual
-- ---------------------------------------------------
create table periodoActual(
	periodoActual int,
	foreign key (periodoActual) references periodo(idPeriodo)
);