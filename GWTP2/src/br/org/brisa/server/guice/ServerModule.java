package br.org.brisa.server.guice;

import br.org.brisa.server.LoginHandler;
import br.org.brisa.shared.LoginAction;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import com.gwtplatform.dispatch.shared.SecurityCookie;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {

		bindConstant().annotatedWith(SecurityCookie.class).to("MYCOOKIE");

		bindHandler(LoginAction.class, LoginHandler.class);
	}
}
