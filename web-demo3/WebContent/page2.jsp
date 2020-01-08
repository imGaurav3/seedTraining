<%@page import="web.demo.model.Students"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dispaly Page2</title>
</head>
<body>
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
					out.write("<tr>");
					out.write("<td>"+s.getName()+"</td>");
					out.write("<td>"+s.getEmail()+"</td>");
					out.write("<td>"+s.getPhone()+"</td>");
					out.write("<td>"+s.getBatch()+"</td>");
					out.write("<td>"+s.getBatch()+"</td>");
					out.write("</tr>");
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>