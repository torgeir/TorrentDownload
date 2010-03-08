package at.torgeir.gwt.torrentdownload.client;

import at.torgeir.gwt.torrentdownload.client.presenter.Presenter;
import at.torgeir.gwt.torrentdownload.client.presenter.UnitsPresenter;
import at.torgeir.gwt.torrentdownload.client.service.TorrentDownloadServiceAsync;
import at.torgeir.gwt.torrentdownload.client.view.TorrentDownloadView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter {

	private final HandlerManager eventBus;
	private final TorrentDownloadServiceAsync service;
	private HasWidgets container;
	
	public AppController(TorrentDownloadServiceAsync service, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.service = service;
		
		bind();
	}
	
	private void bind() {
	}

	public void go(final HasWidgets container) {
		this.container = container;
		Presenter presenter = new UnitsPresenter(service, eventBus, new TorrentDownloadView(service, null));
		presenter.go(container);
	}

}
