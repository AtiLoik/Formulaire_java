package com.objis.gestionformationssession.service;

import com.objis.gestionformationssession.dao.UserDAO;
import com.objis.gestionformationssession.metier.User;

public class ServiceAuth {
	
	private UserDAO userDAO;
	
	public ServiceAuth() {
		userDAO = new UserDAO();
	}
	
	public boolean authentification(User user) {
		boolean valid = false;
		
		if("Cedric".equalsIgnoreCase(user.getLogin()) && "azerty".equalsIgnoreCase(user.getPassword())) {
			valid = true;
		}else {
			valid = false;
		}
		
		return valid;
	}
}
