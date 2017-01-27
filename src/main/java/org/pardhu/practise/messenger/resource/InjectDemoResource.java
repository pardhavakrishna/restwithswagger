package org.pardhu.practise.messenger.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injections")
public class InjectDemoResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/matrixparams")
	public String getMetricParams(@MatrixParam("param") String paramValue){
		return "Test For Metric Params: " + paramValue ;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/headerparams")
	public String getHeaderParams(@HeaderParam("param") String paramValue){
		return "Test For Header Params: " + paramValue ;
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cookieparams")
	public String getCookieParams(@CookieParam("param") String paramValue){
		return "Test For Cookie Params: " + paramValue ;
	}
	
	@GET
	@Path("/context")
	public String getParasUsingContext (@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String absolutePath  = uriInfo.getAbsolutePath().toString();
		
		return "Test Context: " +absolutePath + " header param: " + headers.getHeaderString("param");
	}
}
