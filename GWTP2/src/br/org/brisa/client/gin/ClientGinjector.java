package br.org.brisa.client.gin;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;

import br.org.brisa.client.gatekeeper.AdminGatekeeper;
import br.org.brisa.client.gatekeeper.MasterGatekeeper;
import br.org.brisa.client.gatekeeper.UserGatekeeper;
import br.org.brisa.client.presenter.HomePresenter;
import br.org.brisa.client.presenter.HeaderPresenter;
import br.org.brisa.client.presenter.LoginPresenter;
import br.org.brisa.client.presenter.UserPresenter;
import br.org.brisa.client.presenter.AdminPresenter;
import br.org.brisa.client.presenter.MasterPresenter;
import br.org.brisa.client.presenter.ForbiddenPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<HomePresenter> getHomePresenter();

	AsyncProvider<HeaderPresenter> getHeaderPresenter();

	AsyncProvider<LoginPresenter> getLoginPresenter();

	AsyncProvider<UserPresenter> getUserPresenter();

	AsyncProvider<AdminPresenter> getAdminPresenter();

	AsyncProvider<MasterPresenter> getMasterPresenter();
	
	UserGatekeeper getUserGatekeeper();
	
	AdminGatekeeper getAdminGatekeeper();
	
	MasterGatekeeper getMasterGatekeeper();

	AsyncProvider<ForbiddenPresenter> getForbiddenPresenter();

}
