package at.torgeir.gwt.torrentdownload.server;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


import at.torgeir.gwt.torrentdownload.client.service.TorrentDownloadService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TorrentDownloadServiceImpl extends RemoteServiceServlet implements TorrentDownloadService {

	public TorrentDownloadServiceImpl() {
		
	}

	@Override
	public String greet() {
		Locale locale = new Locale("nb", "no");
		DateFormat dateInstance = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL, locale);
		Date date = new Date();
		return dateInstance.format(date);
	}

}