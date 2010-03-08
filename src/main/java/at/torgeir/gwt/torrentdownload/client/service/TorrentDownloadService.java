package at.torgeir.gwt.torrentdownload.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("torrentdownload")
public interface TorrentDownloadService extends RemoteService {

	String greet();
	
}
