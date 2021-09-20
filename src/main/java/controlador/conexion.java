package controlador;

import java.sql.*;


import javax.swing.JOptionPane;

public class conexion {
Connection cnn;
public Connection conexiondb() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

	try {
		cnn=DriverManager.getConnection("jdbc:mysql://localhost/tienda_virtual","root","");

	} catch (SQLException e) {
		e.printStackTrace();
				
	}
	JOptionPane.showMessageDialog(null, "Conexion ok")	;
	
	
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return cnn;
}
}