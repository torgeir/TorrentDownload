package at.torgeir.gwt.torrentdownload.client.view;

import at.torgeir.gwt.torrentdownload.client.datasource.DataSource;
import at.torgeir.gwt.torrentdownload.client.presenter.UnitsPresenter;
import at.torgeir.gwt.torrentdownload.client.service.TorrentDownloadServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TorrentDownloadView extends Composite implements UnitsPresenter.Display {
	
	private static final String DEFAULT_HEIGHT = "20";
	
	VLayout mainPanel;
	
	public TorrentDownloadView(TorrentDownloadServiceAsync service, DataSource object) {
		
		Label label = new Label("Status: ");
		label.setHeight(DEFAULT_HEIGHT);
		label.setWidth(DEFAULT_HEIGHT);
		
		final Label status = new Label("");
		status.setHeight(DEFAULT_HEIGHT);
		
		final FormPanel formPanel = new FormPanel();
		formPanel.setAction(GWT.getModuleBaseURL() + "torrentupload");
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		formPanel.setStyleName("uploadform");
		formPanel.setHeight(DEFAULT_HEIGHT);
		
		FileUpload fileUpload = new FileUpload();
		fileUpload.setName("file");
		
		formPanel.add(fileUpload);

		HLayout statusLayout = new HLayout();
		statusLayout.setMembers(label, status);
		statusLayout.setMembersMargin(5);
		
		mainPanel = new VLayout();
		mainPanel.addMember(statusLayout);
		mainPanel.addMember(formPanel);
		
		formPanel.addSubmitCompleteHandler(new SubmitCompleteHandler() {
			
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				status.setContents(event.getResults().replaceAll("</?pre>", ""));
				System.out.println("<"+event.getResults()+">");
			}
		});
		
		mainPanel.addMember(new Button("Upload", new com.google.gwt.event.dom.client.ClickHandler() {
			
			@Override
			public void onClick(com.google.gwt.event.dom.client.ClickEvent arg0) {
				formPanel.submit();
			}
			
		}));
		
		initWidget(mainPanel);
	}

	public Widget asWidget() {
		return this;
	}


}
