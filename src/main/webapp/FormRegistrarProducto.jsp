<%@page import="dao.ClassProductoImp"%>
<%@page import="model.TblProductocl3"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center"> Registrar Producto</h1>
<form action="ControladorProducto" method="post">
	<table border="2" align="center">
	<tr>
	<td>Nombre</td>
	<td><input type="text" name="nombre"></td>
	</tr>
	<tr>
	<td>Precio Venta</td>
	<td><input type="number" name="precioventa"></td>
	</tr>
	<tr>
	<td>Precio Compra</td>
	<td><input type="number" name="preciocomp"></td>
	</tr>
	<tr>
	<td>Estado</td>
	<td><input type="text" name="estado"></td>
	</tr>
	<tr>
	<td>Descripcion</td>
	<td><input type="text" name="descrip"></td>
	</tr>
	<tr>
	<td  align="center" colspan="2">
	<input type="submit" value="Registrar">
	</td>
	</tr>
	</table>
</form>
		<% String mensaje = (String) request.getAttribute("mensaje"); %>
	    <% if (mensaje != null && !mensaje.isEmpty()) { %>
	        <p align="center" color="blue"><%= mensaje %></p>
	
	    <% } %>

    <% ClassProductoImp crud = new  ClassProductoImp();%>
    <h1 style="color: blue" align="center">Dato Registrado en la BD</h1>
            	<h2 align="center">Listado de Productos</h2>
    <table border="2"  align="center">
		<tr>
			<td>Codigo</td>
			<td>Nombre</td>
			<td>precioVenta</td>
			<td>precioCompra</td>
			<td>Estado</td>
			<td>Descripcion</td>
			<td colspan="2">Acciones</td>
		</tr>
		<%
			List<TblProductocl3> listadoProducto = (List<TblProductocl3>)request.getAttribute("listadoproductos");
			if(listadoProducto != null){
				for(TblProductocl3 li : listadoProducto){
				%>
					<tr>
						<td><%=li.getIdproductocl3()%></td>
						<td><%=li.getNombrecl3()%></td>
						<td><%=li.getPrecioventacl3()%></td>
						<td><%=li.getPreciocompcl3()%></td>
						<td><%=li.getEstadocl3()%></td>
						<td><%=li.getDescripcl3()%></td>
						<td><a href="ControladorProducto?accion=Modificar&codigo=<%=li.getIdproductocl3()%>">Actualizar</a></td>
						<td><a href="ControladorProducto?accion=Eliminar&codigo=<%=li.getIdproductocl3()%>">Borrar</a></td>
						
					</tr>
				<% 	
				}
			}
		%>
		
	</table>
</form>
</body>
</html>