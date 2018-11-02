drop table student_grade if exists;

create table student_grade (
	student_id_card varchar(255) not null, 
	subject_code varchar(255) not null, 
	university varchar(255) not null, 
	grade_code varchar(1) not null, 
	graduation_year bigint not null, 
	originating_state varchar(2) not null, 
	time_placed timestamp not null, 
	primary key (student_id_card, subject_code, university));

insert into student_grade (student_id_card,subject_code,grade_code,graduation_year,time_placed,originating_state,university) values 
	('X23498589F','BIO1','A',2005,parsedatetime('2018-10-24 10:27:44', 'yyyy-MM-dd hh:mm:ss'),'NY','NYU'),
	('X23498589F','BIO2','A',2005,CURRENT_TIMESTAMP(),'NY','NYU'),	
	('X23498589F','BIO3','A',2005,CURRENT_TIMESTAMP(),'NY','NYU');
	