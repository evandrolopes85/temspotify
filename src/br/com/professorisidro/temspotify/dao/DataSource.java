package br.com.professorisidro.temspotify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String hostname;
	private String username;
	private String password;
	private String database;
	private Connection connection;
	
	public DataSource() {
		try {
			hostname = "localhost";
			username = "temspotify";
			password = "T3m@ul@!";
			database = "temspotify";
			
			String url = "jdbc:mysql://"+hostname+":3306/"+database;
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("DATASOURCE CONECTED");
		}catch(SQLException ex) {
			System.out.println("ERRO ao conectar : " + ex.getMessage());
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}
