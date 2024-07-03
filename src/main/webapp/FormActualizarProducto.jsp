<%@page import="model.TblProductocl3"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Cliente</title>
</head>
<body bgcolor="#c5dec9">
	<h1 align="center">Actualizar Cliente</h1>
	
	<form action="ControladorProducto" method="post">
	
	<%
	String codigo=request.getAttribute("codigo").toString();
	String nombre = (request.getAttribute("nombre") != null)?request.getAttribute("nombre").toString():"";
	String precioventa = (request.getAttribute("precioventa") != null)?request.getAttribute("precioventa").toString():"";
	String preciocomp = (request.getAttribute("preciocomp") != null)?request.getAttribute("preciocomp").toString():"";
	String estado = (request.getAttribute("estado") != null)?request.getAttribute("estado").toString():"";
	String descrip =(request.getAttribute("descrip") != null)?request.getAttribute("descrip").toString():"";
	%>
	
	
		<table align="center" border="2">
			<tr>
				<td>
				<input type="hidden" name="codigo" value="<%=codigo%>">
				</td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td>
				<input type="text" name="nombre" value="<%=nombre%>">
				</td>
			</tr>
			<tr>
				<td>Precio Venta</td>
				<td>
				<input type="text" name="precioventa" value="<%=precioventa%>">
				</td>
			</tr>
			<tr>
				<td>Precio Compra</td>
				<td>
				<input type="text" name="preciocomp" value="<%=preciocomp%>">
				</td>
			</tr>
			<tr>
				<td>Estado</td>
				<td>
				<input type="text" name="estado" value="<%=estado%>">
				</td>
			</tr>
			<tr>
				<td>Descripcion</td>
				<td>
				<input type="text" name="descrip" value="<%=descrip%>">
				</td>
			</tr>
			
			<tr>
				<td colspan="2"  align="center" >
					<input type="submit" value="Actualizar Producto">
				</td>
			</tr>
		
		</table>
	
	
	</form>
</body>
</html>