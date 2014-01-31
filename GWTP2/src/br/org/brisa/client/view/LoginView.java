package br.org.brisa.client.view;

import br.org.brisa.client.presenter.LoginPresenter;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class LoginView extends ViewImpl implements LoginPresenter.MyView {

	@UiField
	Label usernameLabel;
	@UiField
	TextBox usernameTextBox;
	@UiField
	Label passwordLabel;
	@UiField
	PasswordTextBox passwordTextBox;
	@UiField
	Button submitButton;
	@UiField
	HTMLPanel widgetContent;

	private final Widget widget;
	
	public interface Binder extends UiBinder<Widget, LoginView> {
	}

	@Inject
	public LoginView(final Binder binder, final Button submitButton) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	public Label getUsernameLabel() {
		return usernameLabel;
	}

	public TextBox getUsernameTextBox() {
		return usernameTextBox;
	}

	public Label getPasswordLabel() {
		return passwordLabel;
	}

	public PasswordTextBox getPasswordTextBox() {
		return passwordTextBox;
	}

	public Button getSubmitButton() {
		return submitButton;
	}
}
