package com.gsoeller.armstrong.ArmstrongService;

import com.gsoeller.armstrong.resources.GithubResource;
import com.gsoeller.armstrong.ssh.SSHClient;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ArmstrongApplication extends Application<ArmstrongConfiguration>{

	public static void main(String[] args) throws Exception {
		new ArmstrongApplication().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<ArmstrongConfiguration> bootstrap) {
		
	}

	@Override
	public void run(ArmstrongConfiguration conf, Environment env)
			throws Exception {
		env.jersey().register(new GithubResource());
		SSHClient client = new SSHClient();
		client.connect();
		client.executeCommand("pwd");
		
	}

}
