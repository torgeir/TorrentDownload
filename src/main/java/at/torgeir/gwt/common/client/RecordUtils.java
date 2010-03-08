package at.torgeir.gwt.common.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public final class RecordUtils {


    public static ListGridRecord getNewRecord(DSRequest request) {
        ListGridRecord newRecord = getOldRecord(request);
        JavaScriptObject data = request.getData();
        JSOHelper.apply(data, newRecord.getJsObj());
        
        return newRecord;
    }

	private static ListGridRecord getOldRecord(DSRequest request) {
		JavaScriptObject oldValues = request.getAttributeAsJavaScriptObject("oldValues");
        ListGridRecord newRecord = new ListGridRecord();
        JSOHelper.apply(oldValues, newRecord.getJsObj());
        
		return newRecord;
	}

}
