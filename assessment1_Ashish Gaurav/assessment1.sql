create table patients(id NUMBER(4) PRIMARY KEY, name VARCHAR(20) NOT NULL, email VARCHAR(20) UNIQUE ,reg_date DATE);

create table medicines(id NUMBER(4) PRIMARY KEY, name VARCHAR(20) NOT NULL);

create table prescriptions(id NUMBER(4) PRIMARY KEY, prescribed_date DATE, patient_id NUMBER(4));

create table relation(id NUMBER(4) PRIMARY KEY, prescription_id NUMBER(4), medicine_id NUMBER(4));

alter table prescriptions
add CONSTRAINT fk_patientid FOREIGN KEY(patient_id) REFERENCES patients(id);

alter table relation
add CONSTRAINT fk_prescriptionid FOREIGN KEY(prescription_id) REFERENCES prescriptions(id);

alter table relation
add CONSTRAINT fk_medicineid FOREIGN KEY(medicine_id) REFERENCES medicines(id);

insert into patients values (1,'Ashish','ashish@gmail.com',sysdate);
insert into patients values (2,'Rahul','ra@gmail.com',sysdate);
insert into patients values (3,'Danish','dns@gmail.com',sysdate);

insert into medicines values (1,'Crocin');
insert into medicines values (2,'Maximo');
insert into medicines values (3,'Azithrall');
insert into medicines values (4,'Rablet');
insert into medicines values (5,'Calpol');

insert into prescriptions values (1,sysdate,1);
insert into prescriptions values (2,sysdate,2);
insert into prescriptions values (3,sysdate,3);

insert into relation values (1,1,1);
insert into relation values (2,1,4);
insert into relation values (3,2,2);
insert into relation values (4,2,5);
insert into relation values (5,2,3);
insert into relation values (6,3,5);

SELECT * from patients;
select * from medicines;
select * from prescriptions;
select * from relation;

select * from patients 
where reg_date BETWEEN '01-JAN-2019' and sysdate;

select a.name, b.id as "Prescribed ID", b.prescribed_date, c.name as "Medicine Name"
from patients a, prescriptions b, medicines c, relation d
where a.id = b.patient_id and b.id = d.prescription_id and c.id = d.medicine_id;