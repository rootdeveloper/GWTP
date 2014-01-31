package br.org.brisa.client.presenter;

import br.org.brisa.client.place.NameTokens;
import br.org.brisa.shared.CurrentUser;
import br.org.brisa.shared.LoginAction;
import br.org.brisa.shared.LoginActionResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class LoginPresenter extends
		Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {

	public interface MyView extends View {
		public Label getUsernameLabel();

		public TextBox getUsernameTextBox();

		public Label getPasswordLabel();

		public PasswordTextBox getPasswordTextBox();

		public Button getSubmitButton();
	}
	
	@ProxyCodeSplit
	@NameToken(NameTokens.login)
	public interface MyProxy extends ProxyPlace<LoginPresenter> {
	}

	@Inject
	public LoginPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, PlaceManager placeManager, DispatchAsync dispatcher,
			CurrentUser user) {
		super(eventBus, view, proxy); 
		
		this.placeManager = placeManager;
		this.dispatcher = dispatcher;
		this.user = user;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, HeaderPresenter.SLOT_HEADER, this);
	}
	
	@Override
	protected void onBind() {
		super.onBind();
		getView().getSubmitButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				login();
		}
	});
	}
	private void executeLogin(){
		LoginAction action = new LoginAction(getView().getPasswordTextBox().getText(),
				getView().getPasswordTextBox().getText());
		dispatcher.execute(action, new AsyncCallback<LoginActionResult>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
			

			@Override
			public void onSuccess(LoginActionResult result) {
				PlaceRequest request = new PlaceRequest(NameTokens.user);
				placeManager.revealPlace(request);
				
			}
		});
	}
	
	private void login() {
		
		String loginText = getView().getUsernameTextBox().getText();
		String passwordText = getView().getPasswordTextBox().getText();
		
		dispatcher.execute(new LoginAction(loginText, passwordText),
				new AsyncCallback<LoginActionResult>() {
					
					@Override
					public void onFailure(Throwable caught) {
						
					}

					@Override
					public void onSuccess(LoginActionResult result) {
						user.setRoles(result.getCurrentUser().getRoles());
						user.setUsername(result.getCurrentUser().getUsername());
						
						redirect();
					}
				});
	}

	private void redirect() {
		placeManager.revealPlace(new PlaceRequest(NameTokens.user));
	}
	
	private final DispatchAsync dispatcher;
	private final PlaceManager placeManager;
	private CurrentUser user;
}
