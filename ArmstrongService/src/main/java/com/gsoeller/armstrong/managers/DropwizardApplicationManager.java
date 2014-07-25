package com.gsoeller.armstrong.managers;

import java.util.List;

import com.google.inject.Inject;
import com.gsoeller.armstrong.daos.DropwizardApplicationDao;
import com.gsoeller.armstrong.pojos.DropwizardApplication;

public class DropwizardApplicationManager {

	private DropwizardApplicationDao dao;
	
	@Inject
	public DropwizardApplicationManager(DropwizardApplicationDao dao) {
		this.dao = dao;
	}
	
	public List<DropwizardApplication> getAllApplications() {
		return dao.getAllAplications();
	}
	
	public int addApplication(DropwizardApplication app) {
		return dao.addApplication(app.getName(), app.getDeployablePath(), app.getBuildPath(), app.getYmlPath());
	}
}
