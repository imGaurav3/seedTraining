<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	
	<h1>Welcome from JSP....</h1>
	
	<%
		out.write("Welcome from the Script!!!");
	%>
	<%! String name = "Ashish"; %>
	<%=name %>
	<form action="index.jsp" method="get">
		Number 1: <input type="number" min="1" name="num1"/>
		Number 2: <input type="number" min="1" name="num2"/>
		<button type="submit" name = "subBtn">Multiply</button>
	
	</form>
	<%
		if(request.getParameter("num1")!= null && request.getParameter("num2")!= null){
			int num1 = Integer.parseInt(request.getParameter("num1").trim());
			int num2 = Integer.parseInt(request.getParameter("num2").trim());
			
			for(int i=0;i<=num2;i++){
				out.write("<p>"+num1 + " * "+i+" = "+(num1*i)+"</p>");
			}
		}
	%>
	
	
</body>
</html>