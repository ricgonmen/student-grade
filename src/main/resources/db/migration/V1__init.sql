drop table student_grade if exists;

create table student_grade (
	student_id_card varchar(255) generated by default as identity, 
	grade_code varchar(1), 
	graduation_year bigint, 
	originating_state varchar(2), 
	subject_code varchar(4), 
	time_placed date, 
	university varchar(255), 
primary key (student_id_card))