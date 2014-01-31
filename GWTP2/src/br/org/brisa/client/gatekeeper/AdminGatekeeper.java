package br.org.brisa.client.gatekeeper;

import br.org.brisa.shared.CurrentUser;
import br.org.brisa.shared.Role;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

public class AdminGatekeeper implements Gatekeeper{

	CurrentUser currentUser;
	
	@Inject
	public AdminGatekeeper(final CurrentUser currentUser){
		this.currentUser = currentUser;
	}
	
	@Override
	public boolean canReveal() {
		return currentUser.getRoles().contains(Role.ADMINISTRATOR);
	}

}
