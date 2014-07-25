package com.gsoeller.armstrong.ssh;

import com.google.common.base.Optional;

public class Commands {
	private static final String CD_TO_BUILD_DIRECTORY = "cd /var/build"; 
	private static final String CD_TO_DEPLOY_DIRECTORY = "cd /var/www"; 
	private static final String UPDATE_CODE ="git pull origin master"; 
	private static final String ADD_REPOSITORY = "git clone";
	private static final String BUILD_CODE = "mvn package";
	private static final String GET_PROJECTS = "cd /var/www && ls";

	private Optional<String> projectName = Optional.absent();
	private Optional<String> appName = Optional.absent();
	private Optional<String> repoUrl = Optional.absent();


	
	public Optional<String> getDeployDirectory() {
		if (appName.isPresent()) {
			return Optional.of(String.format("%s/%s", CD_TO_DEPLOY_DIRECTORY, appName.get()));
		}
		return Optional.absent();
	}
	
	public Optional<String> getBuildDirectory() {
		if (projectName.isPresent() && appName.isPresent()) {
			return Optional.of(String.format("%s/%s/%s", CD_TO_BUILD_DIRECTORY, appName.get(), projectName.get()));
		}
		return Optional.absent();
	}
	
	public Optional<String> getProjectName() {
		return projectName;
	}

	public void setProjectName(Optional<String> projectName) {
		this.projectName = projectName;
	}

	public Optional<String> getAppName() {
		return appName;
	}

	public void setAppName(Optional<String> appName) {
		this.appName = appName;
	}

	public Optional<String> getRepoUrl() {
		if (repoUrl.isPresent()) {
			return Optional.of(String.format("%s %s", ADD_REPOSITORY, repoUrl.get()));
		}
		return Optional.absent();
	}
	
	public Optional<String> addRepo() {
		if (repoUrl.isPresent()) {
			return Optional.of(String.format("%s && %s %s", CD_TO_BUILD_DIRECTORY, ADD_REPOSITORY, repoUrl.get()));
		}
		return Optional.absent();
	}

	public void setRepoUrl(Optional<String> repoUrl) {
		this.repoUrl = repoUrl;
	}

	
	public Optional<String> updateCode() {
		if (projectName.isPresent()) {
			return Optional.of(String.format("%s/%s && %s", CD_TO_BUILD_DIRECTORY, projectName.get(), UPDATE_CODE));
		}
		return Optional.absent();
	}
	
	public Optional<String> buildCode() {
		Optional<String> buildDirectory = getBuildDirectory();
		if (buildDirectory.isPresent()) {
			return Optional.of(String.format("%s && %s", buildDirectory.get(), BUILD_CODE));
		}
		return Optional.absent();
	}

	public String getProjects() {
		return GET_PROJECTS;
	}
}
