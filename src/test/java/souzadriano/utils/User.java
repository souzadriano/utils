package souzadriano.utils;

import java.util.Set;

public class User extends Person {
	
	public static final String TEST = "TEST";

	private Set<String> permissions;
	private Login login;

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
