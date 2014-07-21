package com.gsoeller.armstrong.ssh;

import com.google.common.base.Optional;

public class Commands {
	private static final String CD_TO_BUILD_DIRECTORY = "cd /var/build"; 
	private static final String CD_TO_DEPLOY_DIRECTORY = "cd /var/www"; 
	private static final String UPDATE_CODE ="git pull origin master"; 
	private static final String ADD_REPOSITORY = "git clone";

	private Optional<String> projectName = Optional.absent();
	private Optional<String> serviceName = Optional.absent();
	private Optional<String> repoUrl = Optional.absent();


	
	public Optional<String> getDeployDirectory() {
		if (serviceName.isPresent()) {
			return Optional.of(String.format("%s/%s", CD_TO_DEPLOY_DIRECTORY, serviceName.get()));
		}
		return Optional.absent();
	}
	
	public Optional<String> getBuildDirectory() {
		if (projectName.isPresent()) {
			return Optional.of(String.format("%s/%s", CD_TO_BUILD_DIRECTORY, projectName.get()));
		}
		return Optional.absent();
	}
	
	public Optional<String> getProjectName() {
		return projectName;
	}

	public void setProjectName(Optional<String> projectName) {
		this.projectName = projectName;
	}

	public Optional<String> getServiceName() {
		return serviceName;
	}

	public void setServiceName(Optional<String> serviceName) {
		this.serviceName = serviceName;
	}

	public Optional<String> getRepoUrl() {
		if (repoUrl.isPresent()) {
			return Optional.of(String.format("%s %s", ADD_REPOSITORY, repoUrl.get()));
		}
		return Optional.absent();
	}

	public void setRepoUrl(Optional<String> repoUrl) {
		this.repoUrl = repoUrl;
	}

	public static String getUpdateCode() {
		return UPDATE_CODE;
	}
}
