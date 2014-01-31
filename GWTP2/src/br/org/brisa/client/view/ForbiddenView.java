package br.org.brisa.client.view;

import br.org.brisa.client.presenter.ForbiddenPresenter;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class ForbiddenView extends ViewImpl implements
		ForbiddenPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, ForbiddenView> {
	}

	@Inject
	public ForbiddenView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
