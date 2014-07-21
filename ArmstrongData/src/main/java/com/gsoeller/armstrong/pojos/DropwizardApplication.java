package com.gsoeller.armstrong.pojos;

import java.net.URI;

public class DropwizardApplication {
	
	private URI githubUrl;
	private boolean deployed = false;

	public boolean isDeployed() {
		return deployed;
	}

	public void setDeployed(boolean deployed) {
		this.deployed = deployed;
	}

	public URI getGithubUrl() {
		return githubUrl;
	}

	public void setGithubUrl(URI githubUrl) {
		this.githubUrl = githubUrl;
	}
	
}
