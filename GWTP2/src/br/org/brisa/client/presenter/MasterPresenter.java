package br.org.brisa.client.presenter;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import br.org.brisa.client.place.NameTokens;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import br.org.brisa.client.gatekeeper.MasterGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import br.org.brisa.client.presenter.HeaderPresenter;

public class MasterPresenter extends
		Presenter<MasterPresenter.MyView, MasterPresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.master)
	@UseGatekeeper(MasterGatekeeper.class)
	public interface MyProxy extends ProxyPlace<MasterPresenter> {
	}

	@Inject
	public MasterPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, HeaderPresenter.SLOT_HEADER, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
