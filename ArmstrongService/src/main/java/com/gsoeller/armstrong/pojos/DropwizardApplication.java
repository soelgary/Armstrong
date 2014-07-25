package com.gsoeller.armstrong.pojos;

public class DropwizardApplication {

	private String name;
	private String deployablePath;
	private String buildPath;
	private String ymlPath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeployablePath() {
		return deployablePath;
	}

	public void setDeployablePath(String deployablePath) {
		this.deployablePath = deployablePath;
	}

	public String getBuildPath() {
		return buildPath;
	}

	public void setBuildPath(String buildPath) {
		this.buildPath = buildPath;
	}

	public String getYmlPath() {
		return ymlPath;
	}

	public void setYmlPath(String ymlPath) {
		this.ymlPath = ymlPath;
	}

}
