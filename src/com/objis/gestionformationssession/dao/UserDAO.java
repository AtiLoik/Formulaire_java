package com.objis.gestionformationssession.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

	private String url = "jdbc:mysql://localhost/gestionformations";
	private String sql_login = "root";
	private String sql_password = "";
	
	
	public void insert(String nom, String prenom, String mail, String mdp) {
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "INSERT INTO user (nom, prenom, mail, mdp) VALUES ('"+ nom +"', '"+ prenom +"', '"+ mail +"', '"+ mdp +"')";
			
			st.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean authentification(String login, String mdp) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "SELECT * FROM user WHERE mail = '"+ login +"' AND mdp = '"+ mdp +"'";
			
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
