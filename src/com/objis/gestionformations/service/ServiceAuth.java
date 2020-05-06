package com.objis.gestionformations.service;

public class ServiceAuth {
	public boolean estValide(String login, String pwd) {

		if (("manga".equalsIgnoreCase(login))
				&& ("aimejava".equalsIgnoreCase(pwd)))
			return true;
		else
			return false;
	}

}
