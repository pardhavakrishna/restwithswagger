package org.pardhu.practise.messenger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserExceptionMapper extends Throwable implements ExceptionMapper<Throwable> {

	private static final long serialVersionUID = 1L;

	@Override
	public Response toResponse(Throwable arg0) {
		arg0.printStackTrace();
		return Response.status(500).entity(arg0.getMessage()).type("text/plain").build();
	}

}
