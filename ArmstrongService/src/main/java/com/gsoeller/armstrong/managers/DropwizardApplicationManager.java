package com.gsoeller.armstrong.managers;

import java.util.List;

import com.google.common.base.Optional;
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
	
	public Optional<DropwizardApplication> getApplication(String appName) {
		List<DropwizardApplication> apps = dao.getApplication(appName);
		if (apps.size() == 1) {
			return Optional.of(apps.get(0));
		}
		return Optional.absent();
	}
	
	public int addApplication(DropwizardApplication app) {
		return dao.addApplication(app.getName(), app.getDeployPath(), app.getBuildPath(), app.getYmlPath());
	}
}
