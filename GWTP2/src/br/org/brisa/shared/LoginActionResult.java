package br.org.brisa.shared;

import com.gwtplatform.dispatch.shared.Result;
import br.org.brisa.shared.CurrentUser;

public class LoginActionResult implements Result {

	private CurrentUser currentUser;

	@SuppressWarnings("unused")
	private LoginActionResult() {
		// For serialization only
	}

	public LoginActionResult(final CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	public CurrentUser getCurrentUser() {
		return currentUser;
	}
}
