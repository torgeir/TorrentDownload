package at.torgeir.gwt.torrentdownload.client;

import at.torgeir.gwt.torrentdownload.client.service.TorrentDownloadService;
import at.torgeir.gwt.torrentdownload.client.service.TorrentDownloadServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class TorrentDownload implements EntryPoint {

	public void onModuleLoad() {
		TorrentDownloadServiceAsync service = GWT.create(TorrentDownloadService.class);
		
		HandlerManager eventBus = new HandlerManager(null);
		AppController appController = new AppController(service, eventBus);
		appController.go(RootPanel.get());
		
	}
}
