package com.gsoeller.armstrong.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.quartz.SchedulerException;

import com.google.inject.Inject;
import com.gsoeller.armstrong.managers.DeployManager;
import com.gsoeller.armstrong.pojos.Deploy;

@Path("deploy")
@Produces(MediaType.APPLICATION_JSON)
public class DeployResource {
	
	private DeployManager manager;
	
	@Inject
	public DeployResource(DeployManager manager) {
		this.manager = manager;
	}
	
	
	@GET
	public List<Deploy> getDeploys() {
		return manager.getDeploys();
	}
	
	@POST
	public int deploy(Deploy deploy) throws SchedulerException {
		return manager.deploy(deploy);
	}
	
}
