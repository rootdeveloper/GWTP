package br.org.brisa.client.view;

import br.org.brisa.client.presenter.MasterPresenter;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MasterView extends ViewImpl implements MasterPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, MasterView> {
	}

	@Inject
	public MasterView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
