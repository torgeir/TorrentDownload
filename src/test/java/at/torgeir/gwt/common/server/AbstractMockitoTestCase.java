package at.torgeir.gwt.common.server;

import junit.framework.TestCase;

import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public abstract class AbstractMockitoTestCase extends TestCase {
	
	protected MockHttpServletRequest request;	
	protected MockHttpServletResponse response;
	
	protected AbstractMockitoTestCase() {
		super();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		
		MockitoAnnotations.initMocks(this);
	}
}
