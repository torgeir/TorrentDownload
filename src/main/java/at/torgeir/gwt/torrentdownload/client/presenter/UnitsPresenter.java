package at.torgeir.gwt.torrentdownload.client.presenter;

import at.torgeir.gwt.torrentdownload.client.service.TorrentDownloadServiceAsync;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
public class UnitsPresenter implements Presenter {

	public interface Display {

		Widget asWidget();
		
	}
	
	private final TorrentDownloadServiceAsync service;
	private final HandlerManager handlerManager;
	private final Display display;
	
	public UnitsPresenter(TorrentDownloadServiceAsync service, HandlerManager handlerManager, Display display) {
		this.service = service;
		this.handlerManager = handlerManager;
		this.display = display;
	}
	
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

	private void bind() {
		
	}

}
