package br.org.brisa.server;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import br.org.brisa.shared.CurrentUser;
import br.org.brisa.shared.LoginAction;
import br.org.brisa.shared.LoginActionResult;
import br.org.brisa.shared.Role;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class LoginHandler implements ActionHandler<LoginAction, LoginActionResult> {

	private ServletContext servletContext;
	private Provider<HttpServletRequest> requestProvider;

	@Inject
	LoginHandler(ServletContext servletContext,
			Provider<HttpServletRequest> requestProvider) {
		this.servletContext = servletContext;
		this.requestProvider = requestProvider;
	}

	@Override
	public LoginActionResult execute(LoginAction action, ExecutionContext context)
			throws ActionException {

		String username = action.getUsername();
		String password = action.getPassword();

		CurrentUser user = isUserValid(username, password);

		return new LoginActionResult(user);
	}

	private CurrentUser isUserValid(String username, String password) {

		CurrentUser user = null;

		if ("admin".equals(username) && "admin".equals(password)) {
			user = new CurrentUser();
			user.setUsername("admin");
			ArrayList<Role> roles = new ArrayList<Role>();
			roles.add(Role.USER);
			roles.add(Role.MASTER);
			roles.add(Role.ADMINISTRATOR);
			user.setRoles(roles);
		} else if ("master".equals(username) && "master".equals(password)) {
			user = new CurrentUser();
			user.setUsername("master");
			ArrayList<Role> roles = new ArrayList<Role>();
			roles.add(Role.USER);
			roles.add(Role.MASTER);
			user.setRoles(roles);
		} else if ("user".equals(username) && "user".equals(password)) {
			user = new CurrentUser();
			user.setUsername("user");
			ArrayList<Role> roles = new ArrayList<Role>(1);
			roles.add(Role.USER);
			user.setRoles(roles);
		}

		return user;

	}

	@Override
	public void undo(LoginAction action, LoginActionResult result,
			ExecutionContext context) throws ActionException {
		// Not undoable
	}

	@Override
	public Class<LoginAction> getActionType() {
		return LoginAction.class;
	}

}
