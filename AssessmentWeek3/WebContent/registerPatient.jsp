<%@page import="assessment.models.Patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Patient</title>
</head>
<body>
	<form action="register" method="post">
		Name: <input type= 'text' name= 'name' />
		<br>
		Email: <input type= 'text' name= 'email' />
		<br>
		Registration Date(dd/mm/yyyy): <input type= 'text' name= 'date' />
		<br>
		
		<button type='submit' name = 'regBtn'>Register</button>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>ID</th><th>Name</th><th>Email</th><th>Date</th>
			</tr>
		</thead>
		<tbody>
		
		<%
		
			List<Patient> patient = null;
			patient = (List<Patient>)request.getAttribute("patients");
			
			if(patient!=null){
				for(Patient s : patient){
					//out.write("<form method='get' action='register'>");
					out.write("<tr>");
					out.write("<td>"+s.getId()+"</td>");
					out.write("<td>"+s.getName()+"</td>");
					out.write("<td>"+s.getEmail()+"</td>");
					out.write("<td>"+s.getDate()+"</td>");
					//out.write("<td>"+"<input type='hidden' name='patientID' value="+s.getId()+">"+"<button type='submit' name='presBtn'>Prescription</button>"+"</td>");
					out.write("</tr>");
					//out.write("</form>");
				}
			}
		%>
		</tbody>
	</table>
	<a href="page2.jsp">Click here to view/create Prescriptions</a>

</body>
</html>