package com.gsoeller.armstrong.ArmstrongService;

import org.skife.jdbi.v2.DBI;

import com.gsoeller.armstrong.daos.DeployDao;
import com.gsoeller.armstrong.daos.DropwizardApplicationDao;
import com.gsoeller.armstrong.managers.DeployManager;
import com.gsoeller.armstrong.managers.DropwizardApplicationManager;
import com.gsoeller.armstrong.resources.ApplicationResource;
import com.gsoeller.armstrong.resources.DeployResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
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
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, conf.getDataSourceFactory(), "mysql");
		final DropwizardApplicationDao dropwizardApplicationDao = jdbi.onDemand(DropwizardApplicationDao.class);
		final DeployDao deployDao = jdbi.onDemand(DeployDao.class);
		DropwizardApplicationManager dropwizardApplicationManager = new DropwizardApplicationManager(dropwizardApplicationDao);
		DeployManager deployManager = new DeployManager(deployDao);
		env.jersey().register(new ApplicationResource(dropwizardApplicationManager));
		env.jersey().register(new DeployResource(deployManager));
		//PropertiesLoader loader = new PropertiesLoader();
		//String host = loader.getProperty("com.gsoeller.armstrong.host");
		//String user = loader.getProperty("com.gsoeller.armstring.user");
		//client.addRepo(host, user, "https://github.com/soelgary/Armstrong.git");
		//client.getProjects();
		
	}

}
