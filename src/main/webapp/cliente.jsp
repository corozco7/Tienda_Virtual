<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MODULO DE GESTION DE CLIENTES</title>
</head>
<body>
<%
//Conexion con=new Conexion();
//con.conexiondb();
String doc="",nom="",ape="",dir="",tel="", co="";
if(request.getParameter("do")!=null){
doc=request.getParameter("do");
nom=request.getParameter("n");
ape=request.getParameter("a");
dir=request.getParameter("d");
tel=request.getParameter("t");
co=request.getParameter("c");
}

%> MODULO DE GESTION DE CLIENTES

<form action="ServletGestionCliente" method= "post">

<p>Documento<br>
<input type="text" name="documento" Value="<%=doc%>" >
<p>Nombre<br>  
<input type="text" name="nombre" Value="<%=nom%>">
<p>Apellido<br>
<input type="text" name="apellido" Value="<%=ape%>">
<p>Dirección<br>
<input type="text" name="direccion"  Value="<%=dir%>">
<p>Teléfono<br> 
<input type="text" name="telefono" Value="<%=tel%>">
<p>Correo<br>
<input type="text" name="correo" Value="<%=co%>">
<p>
<input type="submit" name="btnins" value="Registrar" >
<input type="submit" name="btncon" value="Consultar">
<input type="submit" name="btnact" value="Actualizar">
<input type="submit" name="btneli" value="Eliminar">
</p>
</form>
	
</body>

</html>