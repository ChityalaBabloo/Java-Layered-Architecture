CREATE TABLE Patient(patient_id NUMBER PRIMARY KEY,
patient_name VARCHAR2(20),
age NUMBER(3),
phone VARCHAR2(10),
description VARCHAR2(80),
consultation_date Date);

CREATE SEQUENCE Patient_Id_Seq START WITH 1000;