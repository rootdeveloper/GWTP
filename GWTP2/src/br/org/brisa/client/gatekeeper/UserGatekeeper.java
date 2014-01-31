package br.org.brisa.client.gatekeeper;

import br.org.brisa.shared.CurrentUser;
import br.org.brisa.shared.Role;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

public class UserGatekeeper implements Gatekeeper{

	CurrentUser currentUser;
	
	@Inject
	public UserGatekeeper(final CurrentUser currentUser){
		this.currentUser = currentUser;
	}
	
	@Override
	public boolean canReveal() {
		return currentUser.getRoles().contains(Role.USER);
	}

}
