<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h2>Create</h2>
	
	<form action="CreateServlet" method="post">
		<label for="txtIdProduct"> Id Product</label>
		<input type="text" id="txtIdProduct" name="txtIdProduct" disabled placeholder="Id generated automatically"/>
		<br />
		
		<label for="txtNameProduct">Name Product</label>
		<input type="text" id="txtNameProduct" name="txtNameProduct" required/>
		<br />
		
		<label for="txtPriceProduct">Price Product</label>
		<input type="text" id="txtPriceProduct" name="txtPriceProduct" />
		<br />
		
		<input type="submit" value="Create Product"/>
		
		<a href="../index.jsp">Return to main menu</a>
		
	</form>

<script src="./js/script.js"></script>
</body>
</html>