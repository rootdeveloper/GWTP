package br.org.brisa.client.gin;

import br.org.brisa.client.place.ClientPlaceManager;
import br.org.brisa.client.place.DefaultPlace;
import br.org.brisa.client.place.NameTokens;
import br.org.brisa.client.presenter.AdminPresenter;
import br.org.brisa.client.presenter.HeaderPresenter;
import br.org.brisa.client.presenter.HomePresenter;
import br.org.brisa.client.presenter.LoginPresenter;
import br.org.brisa.client.presenter.MasterPresenter;
import br.org.brisa.client.presenter.UserPresenter;
import br.org.brisa.client.view.AdminView;
import br.org.brisa.client.view.ForbiddenView;
import br.org.brisa.client.view.HeaderView;
import br.org.brisa.client.view.HomeView;
import br.org.brisa.client.view.LoginView;
import br.org.brisa.client.view.MasterView;
import br.org.brisa.client.view.UserView;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Singleton;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.RootPresenter;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

import br.org.brisa.client.presenter.ForbiddenPresenter;
import br.org.brisa.shared.CurrentUser;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		
//		bind(PlaceManager.class).to(ClientPlaceManager.class).in(Singleton.class);
//		bind(RootPresenter.class).asEagerSingleton();
		
		bind(CurrentUser.class).asEagerSingleton();
		
		install(new DefaultModule(ClientPlaceManager.class));
		

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);

		bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
				HomeView.class, HomePresenter.MyProxy.class);
		
		bindPresenter(HeaderPresenter.class, HeaderPresenter.MyView.class,
				HeaderView.class, HeaderPresenter.MyProxy.class);

		bindPresenter(LoginPresenter.class, LoginPresenter.MyView.class,
				LoginView.class, LoginPresenter.MyProxy.class);

		bindPresenter(UserPresenter.class, UserPresenter.MyView.class,
				UserView.class, UserPresenter.MyProxy.class);

		bindPresenter(AdminPresenter.class, AdminPresenter.MyView.class,
				AdminView.class, AdminPresenter.MyProxy.class);

		bindPresenter(MasterPresenter.class, MasterPresenter.MyView.class,
				MasterView.class, MasterPresenter.MyProxy.class);

		bindPresenter(ForbiddenPresenter.class,
				ForbiddenPresenter.MyView.class, ForbiddenView.class,
				ForbiddenPresenter.MyProxy.class);
		
		bindConstant().annotatedWith(SecurityCookie.class).to("MYCOOKIE");
	}
}
