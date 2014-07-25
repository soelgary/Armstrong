package com.gsoeller.armstrong.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.gsoeller.armstrong.managers.DropwizardApplicationManager;
import com.gsoeller.armstrong.pojos.DropwizardApplication;
import com.gsoeller.armstrong.ssh.SSHClient;

@Path("/application")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {
	
	private SSHClient client;
	private DropwizardApplicationManager manager;
	
	@Inject
	public ApplicationResource(SSHClient client, DropwizardApplicationManager manager) {
		this.client = client;
		this.manager = manager;
	}
	
	@GET
	public List<String> getDeployedApplications() {
		return client.getProjects();
	}
	
	@POST
	public int addApplication(DropwizardApplication app) {
		return manager.addApplication(app);
	}
	
	@PUT
	public void deployApplication(String applicationName) {
		
	}
	
}
