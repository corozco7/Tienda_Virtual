package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.conexion;

public class Cliente_DAO {
conexion con=new conexion();
Connection cnn=con.conexiondb();
PreparedStatement ps;
ResultSet rs;
Cliente_DTO usu;
public boolean insertarusuario(Cliente_DTO us) {
	int x;
	boolean dat=false;
	try {
		usu=consultarusuario(us);
		if(usu==null) {
		ps=cnn.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?,?)");
	    ps.setInt(1, us.getDocumento());
	    ps.setString(2, us.getNombre());
	    ps.setString(3, us.getApellido());
	    ps.setString(4, us.getDireccion());
	    ps.setString(5, us.getTelefono());
	    ps.setString(6, us.getCorreo());
	    x= ps.executeUpdate();
	if(x>0) {
		dat=true;
		
	}}
	
		else {
		JOptionPane.showMessageDialog(null, "El usuario ya existe");
	}
		
	} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error al insertar"+e);
	}
	return dat;
}
	
	public Cliente_DTO consultarusuario(Cliente_DTO us) {
		//ps es el enlace con my sql
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes WHERE Cedula_cliente=?");
		    ps.setInt(1, us.getDocumento());
		    rs=ps.executeQuery();
		    //.next me permite ver si por lo menos hay un resgistro
		    if(rs.next()) {
		     usu= new Cliente_DTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		    }
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
return usu;
	}
	
public int eliminar(Cliente_DTO us) {
	int x=0;
	try {
		ps=cnn.prepareStatement("DELETE FROM clientes WHERE Cedula_cliente=?");
	    ps.setInt(1, us.getDocumento());
	   x= ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} return x;
}
	
public boolean actualizar(Cliente_DTO usu) {
	boolean dat=false;
	int x;
	try {
		ps=cnn.prepareStatement("UPDATE clientes SET Nombre_cliente=?, Apellido_cliente=?, Direccion=?, Telefono=?, Correo=? WHERE Cedula_cliente=?");
	    ps.setString(1, usu.getNombre());
	    ps.setString(2, usu.getApellido());
	    ps.setString(3, usu.getDireccion()); 
	    ps.setString(4, usu.getTelefono());
	    ps.setString(5, usu.getCorreo());
	    ps.setInt(6, usu.getDocumento());
	   x= ps.executeUpdate();
	   if(x>0) {
		   dat= true;
	   }
	    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dat;
}
	
	
	
}

