	#-- 1 --

CREATE TABLE Student (
StudentId  int not null auto_increment,
First_name varchar(40) not null,
Last_name varchar(40) not null,
Registration_number int not null,
Date_of_birth date not null,
DateUpdated timestamp default current_timestamp on update current_timestamp,
primary key (StudentId)
);

CREATE TABLE Teacher (
TeacherId  int not null auto_increment,
First_name varchar(40) not null,
Last_name varchar(40) not null,
Date_of_birth date not null,
DateUpdated timestamp default current_timestamp on update current_timestamp,
primary key (TeacherId)
);

CREATE TABLE Course (
CourseId  int not null auto_increment,
Name varchar(40) not null,
DateUpdated timestamp default current_timestamp on update current_timestamp,
AssignedTeacher int,
FOREIGN KEY (AssignedTeacher) REFERENCES Teacher(TeacherId) ON DELETE RESTRICT ON UPDATE CASCADE,
primary key (CourseId)
);

CREATE TABLE Schedule (
ScheduleId int not null auto_increment,
Day_Name varchar(10) not null,
StartTime time not null,
EndTime time not null,
AssignedCourse int,
DateUpdated timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (AssignedCourse) REFERENCES Course(CourseId) ON DELETE RESTRICT ON UPDATE CASCADE,
primary key (ScheduleId)
);

CREATE TABLE Note (
NoteId int not null auto_increment,
First_Note int,
Second_Note int,
Third_Note int,
Final_Note int,
AssignedCourse int,
AssignedStudent int,
DateUpdated timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (AssignedCourse) REFERENCES Course(CourseId) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (AssignedStudent) REFERENCES Student(StudentId) ON DELETE RESTRICT ON UPDATE CASCADE,
primary key (NoteId)
);


CREATE TABLE IF NOT EXISTS `high-school`.`student_has_schedule` (
  `student_StudentId` INT(11) NOT NULL,
  `schedule_ScheduleId` INT(11) NOT NULL,
  PRIMARY KEY (`student_StudentId`, `schedule_ScheduleId`),
  INDEX `fk_student_has_schedule_schedule1_idx` (`schedule_ScheduleId` ASC),
  INDEX `fk_student_has_schedule_student1_idx` (`student_StudentId` ASC),
  CONSTRAINT `fk_student_has_schedule_student1`
    FOREIGN KEY (`student_StudentId`)
    REFERENCES `high-school`.`student` (`StudentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_schedule_schedule1`
    FOREIGN KEY (`schedule_ScheduleId`)
    REFERENCES `high-school`.`schedule` (`ScheduleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    #-- 2 --

INSERT INTO teacher (First_name, Last_name, Date_of_birth)
VALUES ('ALVARO', 'CORREA', '1990-12-12'),
		('RAUL', 'HEREDIA', '1980-09-11'),
        ('MARIA ELENA', 'CORDOVA DE LA IGLESIA', '1985-12-02');

#--

INSERT INTO course (Name, AssignedTeacher)
VALUES ('MATHS', '1'),
		('SCIENCE', '2'),
        ('SPANISH', '3');

#--

INSERT INTO schedule (Day_Name, StartTime, EndTime, AssignedCourse)
VALUES ('MONDAY', '11:00:00', '13:00:00', '1'),
		('MONDAY', '13:30:00', '15:00:00', '1'),
        ('WEDNESDAY', '11:00:00', '13:00:00', '2'),
        ('FRIDAY', '11:00:00', '13:00:00', '3'),
        ('FRIDAY', '15:00:00', '17:00:00', '3');

#--

INSERT INTO student (First_name, Last_name, Registration_number, Date_of_birth)
VALUES ('NATALIA', 'CISNEROS', '1','1996-01-02'),
		('ANTONIO', 'ESCUDERO', '2','1996-02-03'),
        ('FRANCISCO', 'DIOS', '3','1996-03-02'),
        ('OSCAR', 'CORTES', '4','1997-04-13'),
        ('MOHAMED', 'LECHUGA', '5','1997-05-14'),
        ('RAQUEL', 'GRAU', '6','1997-06-05'),
        ('CONSUELO', 'ASENCIO', '7','1998-07-06'),
        ('MARIA MAR', 'MANSO CAÑETE', '8','1998-08-17'),
        ('JOSE MIGUEL', 'COROMINAS', '9','1998-09-19'),
        ('LORENA', 'LLACER', '10','2000-10-10'),
        ('ISMAEL', 'PALLARES', '11','2000-11-11'),
        ('ALICIA', 'OSUNA', '12','2000-12-12');

#--

INSERT INTO student_has_schedule (student_StudentId, schedule_ScheduleId)
VALUES ('1','1'),
		('1','3'),
        ('1','4'),
        ('2','1'),
        ('2','3'),
        ('2','5'),
        ('3','2'),
        ('3','3'),
        ('3','5'),
        ('4','1'),
        ('4','5'),
        ('5','5'),
        ('6','1'),
        ('6','3'),
        ('6','4'),
        ('7','2'),
        ('7','3'),
        ('7','4'),
        ('8','2'),
        ('8','3'),
        ('8','4'),
        ('9','1'),
        ('9','3'),
        ('9','4'),
        ('10','1'),
        ('10','3'),
        ('10','5'),
        ('11','3'),
        ('11','5'),
        ('12','2'),
        ('12','3'),
        ('12','4');

#--

INSERT INTO note (First_Note, Second_Note, Third_Note, Final_Note, AssignedStudent, AssignedCourse)
VALUES ('6','6','9','7','1', '1'),
		('7','7','7','7','1', '2'),
        ('5','6','4','5','1', '3'),
        ('6','6','9','7','2', '1'),
		('7','7','7','7','2', '2'),
        ('5','6','8','6','2', '3'),
        ('8','8','8','8','3', '1'),
		('7','6','8','7','3', '2'),
        ('5','6','9','7','3', '3'),
        ('9','8','8','8','4', '2'),
        ('5','6','9','7','4', '3'),
        ('5','5','5','5','5', '3'),
        ('6','6','9','7','6', '1'),
		('7','7','7','7','6', '2'),
        ('5','6','4','5','6', '3'),
		('6','6','9','7','7', '1'),
		('7','7','7','7','7', '2'),
        ('5','6','8','6','7', '3'),
        ('9','6','9','8','8', '1'),
		('6','6','6','6','8', '2'),
        ('5','6','6','6','8', '3'),
        ('6','6','6','6','9', '1'),
		('10','9','10','10','9', '2'),
        ('8','7','9','8','9', '3'),
        ('6','6','9','7','10', '1'),
		('7','7','7','7','10', '2'),
        ('5','6','8','6','10', '3'),
		('7','7','7','7','11', '2'),
        ('5','6','8','6','11', '3'),
        ('7','7','7','7','12', '1'),
		('7','7','7','7','12', '2'),
        ('10','10','10','10','12', '3');
        
        
        
        
        