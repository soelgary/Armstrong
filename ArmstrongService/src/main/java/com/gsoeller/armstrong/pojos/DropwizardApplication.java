package com.gsoeller.armstrong.pojos;

public class DropwizardApplication {

	private String name;
	private String deployPath;
	private String buildPath;
	private String ymlPath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDeployPath() {
		return deployPath;
	}

	public void setDeployPath(String deployPath) {
		this.deployPath = deployPath;
	}

}
