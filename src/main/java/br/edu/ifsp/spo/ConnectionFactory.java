package br.edu.ifsp.spo;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ConnectionFactory implements ServletContextListener {
	
//	public Connection recuperarConexao() {
//		
//		try {
//			return DriverManager
//					.getConnection("jdbc:mysql://localhost:3306/aula?user=root&password=Hdd1212@");
//			
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		
//		
//	}
	
	public Connection recuperarConexao() {
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/aula");
			return dataSource.getConnection();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}	
	}
     
}

