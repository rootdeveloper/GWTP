package br.org.brisa.shared;

import com.gwtplatform.dispatch.shared.ActionImpl;
import br.org.brisa.shared.LoginActionResult;
import java.lang.String;

public class LoginAction extends ActionImpl<LoginActionResult> {

	private String username;
	private String password;

	@SuppressWarnings("unused")
	private LoginAction() {
		// For serialization only
	}

	public LoginAction(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
}
