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
	
	<!--  <table>
		<thead>
			<tr>
				<th>Name</th><th>Email</th><th>Phone</th><th>Batch</th>
			</tr>
		</thead>
		<tbody>
		<%--
		
			List<Students> student = null; 
			student = (List<Students>)request.getSession().getAttribute("students");
			
			if(student!=null){
				for(Students s : student){
					out.write("<tr>");
					out.write("<td>"+s.getName()+"</td>");
					out.write("<td>"+s.getEmail()+"</td>");
					out.write("<td>"+s.getPhone()+"</td>");
					out.write("<td>"+s.getBatch()+"</td>");
					out.write("</tr>");	
				}
			}
		--%>
		</tbody>
	</table> -->
</body>
</html>