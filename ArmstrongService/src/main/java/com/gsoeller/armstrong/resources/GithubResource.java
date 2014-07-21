package com.gsoeller.armstrong.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/github")
@Produces(MediaType.APPLICATION_JSON)
public class GithubResource {

	@POST
	public void test(Object obj) {
		System.out.println(obj.toString());
	}
	
	@GET
	public boolean testGet() {
		return true;
	}
}
