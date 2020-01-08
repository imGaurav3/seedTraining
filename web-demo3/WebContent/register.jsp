<%@page import="web.demo.model.Students"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		Name: <input type= 'text' name= 'name' />
		<br>
		Email: <input type= 'text' name= 'email' />
		<br>
		Phone: <input type= 'number' name= 'phone' />
		<br>
		Batch type : <select name = 'batch'>
						<option value="java">java</option>
						<option value="informatica">informatica</option>
						<option value="cloud">cloud</option>
		</select>
		<br>
		<button type='submit' name = 'regBtn'>Register</button>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>Name</th><th>Email</th><th>Phone</th><th>Batch</th>
			</tr>
		</thead>
		<tbody>
		
		<%
		
			List<Students> student = null;
			student = (List<Students>)request.getAttribute("students");
			
			if(student!=null){
				for(Students s : student){
					out.write("<form method='get' action='register'>");
					out.write("<tr>");
					out.write("<td>"+s.getName()+"</td>");
					out.write("<td>"+s.getEmail()+"</td>");
					out.write("<td>"+s.getPhone()+"</td>");
					out.write("<td>"+s.getBatch()+"</td>");
					out.write("<td>"+s.getBatch()+"</td>");
					out.write("<td>"+"<input type='hidden' name='del_name' value="+s.getName()+">"+"<button type='submit' name='delBtn'>Delete</button>"+"</td>");
					out.write("<td>"+ "<input type='hidden' name='edit_name' value="+s.getName()+">" +"<button type='submit' name='editBtn'>Edit</button>"+"</td>");
					out.write("</tr>");
					out.write("</form>");
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>