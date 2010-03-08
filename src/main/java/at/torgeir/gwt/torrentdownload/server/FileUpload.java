package at.torgeir.gwt.torrentdownload.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {

	private static final String UPLOAD_DIR = "/tmp/";
	
	private static final long serialVersionUID = 1232743420338494291L;

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileItemFactory factory = new DiskFileItemFactory(); 
		ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            
            for (FileItem item: items) {
            	
                InputStream inputStream = item.getInputStream();

                FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + item.getName());
                
                int len;
                byte[] buffer = new byte[8192];
                while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                }
                
                fileOutputStream.close();
            }
            
            response.getOutputStream().write("ok".getBytes());
            
        }
        catch(Exception e) {
            response.getOutputStream().write("nok".getBytes());
        }
	}
	
}
