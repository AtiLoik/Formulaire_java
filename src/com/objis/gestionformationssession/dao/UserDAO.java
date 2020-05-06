package com.objis.gestionformationssession.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

	private String url = "jdbc:mysql://localhost/GestionFormations";
	private String login = "root";
	private String password = "";
	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public void insert(String nom, String prenom, String mail, String mdp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, mdp);
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, mdp);
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
