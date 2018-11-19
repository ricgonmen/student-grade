drop table student_grade if exists;
drop table grade_code if exists;

create table grade_code (
	code char not null, 
	gpa double not null, 
	graduate varchar(255) not null, 
	undergraduate varchar(255) not null, 
primary key (code));

insert into grade_code (code,gpa,graduate,undergraduate) values 
 ('A',4.0,'Excellent','Excellent'),
 ('B',3.0,'Good','Good/Average'),
 ('C',2.0,'Average','Passing'),
 ('D',1.0,'Passing','Failing'),
 ('F',4.0,'Failing','Failing');

create table student_grade (
	student_id_card varchar(255) not null, 
	subject_code varchar(255) not null, 
	university varchar(255) not null, 
	grade_code char not null, 
	graduation_year integer not null, 
	originating_state varchar(2) not null, 
	time_placed timestamp not null, 
	primary key (student_id_card, subject_code, university));
	
alter table student_grade add constraint FK_GRADE_CODE foreign key (grade_code) references grade_code;
	
insert into student_grade (student_id_card,subject_code,grade_code,graduation_year,time_placed,originating_state,university) values 
	('X23498589F','AAD','A',2005,parsedatetime('2018-10-24 10:27:44', 'yyyy-MM-dd hh:mm:ss'),'NY','NYU'),
	('X23498589F','AAAP','A',2005,CURRENT_TIMESTAMP(),'NY','NYU'),	
	('X23498589F','ACTG','A',2005,CURRENT_TIMESTAMP(),'NY','NYU');
	