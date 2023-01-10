package Tools;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITestTool extends Tool {
	
	 private RequestSpecification request;
	    private Response response;
	    
	    //getter Setter 
		public RequestSpecification getRequest() {
			return this.request;
		}
		public APITestTool setRequest(RequestSpecification request) {
			this.request = request;
			return this;
		}
		public Response getResponse() {
			return this.response;
		}
		public APITestTool setResponse(Response response) {
			this.response = response;
			return this;
			
		}
		
		protected boolean canEqual(final Object other) {
	        return other instanceof APITestTool;
	    }
		 public void close() {
		        this.request = null;
		        this.response = null;
		    }
		 
		
}
