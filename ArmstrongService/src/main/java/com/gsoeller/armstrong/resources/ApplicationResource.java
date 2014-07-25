package com.gsoeller.armstrong.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.gsoeller.armstrong.managers.DropwizardApplicationManager;
import com.gsoeller.armstrong.pojos.DropwizardApplication;

@Path("/application")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {
	
	private DropwizardApplicationManager manager;
	
	@Inject
	public ApplicationResource(DropwizardApplicationManager manager) {
		this.manager = manager;
	}
	
	@GET
	public List<DropwizardApplication> getApplications() {
		return manager.getAllApplications();
	}
	
	@POST
	public int addApplication(DropwizardApplication app) {
		return manager.addApplication(app);
	}
	
	@GET
	@Path("/{appName}")
	public Optional<DropwizardApplication> deployApplication(@PathParam("appName") String appName) {
		return manager.getApplication(appName);
	}
}
