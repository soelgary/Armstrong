package com.gsoeller.armstrong.pojos;

import org.joda.time.DateTime;

import com.google.common.base.Optional;

public class Deploy {
	private String appName;
	private DateTime deployTime;
	private Optional<Boolean> successfullDeploy;
	private boolean inProgress;
	

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public DateTime getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(DateTime deployTime) {
		this.deployTime = deployTime;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public Optional<Boolean> getSuccessfullDeploy() {
		return successfullDeploy;
	}

	public void setSuccessfullDeploy(Optional<Boolean> successfullDeploy) {
		this.successfullDeploy = successfullDeploy;
	}
}
