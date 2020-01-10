<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prescription-Medicine</title>
</head>
<body>
	<form action="register" method="post">
		Prescription ID: <input type= "number" name= 'prescription_id' />
		<br>
		Patient ID: <input type= "number" name= 'patient_id' />
		<br>
		Prescribed Date(dd/mm/yyyy): <input type= 'text' name= 'pres_date' />
		<br>
		Medicine ID: <input type= "number" name= 'patient_id' />
		<br>
		Medicine Name: <input type= 'text' name= 'med_name' />
		<br>
		<button type='submit' name = 'reg1Btn'>Register</button>
	</form>
</body>
</html>