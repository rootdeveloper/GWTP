package br.org.brisa.client.view;

import br.org.brisa.client.presenter.HeaderPresenter;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HeaderView extends ViewImpl implements HeaderPresenter.MyView {

	private final Widget widget;
	@UiField
	HTMLPanel headerContent;

	public interface Binder extends UiBinder<Widget, HeaderView> {
	}

	@Inject
	public HeaderView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot.equals(HeaderPresenter.SLOT_HEADER)) {
			headerContent.clear();
			if (!content.equals(null)) {
				headerContent.add(content);
			} else {
				super.setInSlot(slot, content);
			}
		}
	}

}
