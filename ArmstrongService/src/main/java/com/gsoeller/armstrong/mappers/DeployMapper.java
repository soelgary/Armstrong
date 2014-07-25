package com.gsoeller.armstrong.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.google.common.base.Optional;
import com.gsoeller.armstrong.pojos.Deploy;

public class DeployMapper implements ResultSetMapper<Deploy>{

	public Deploy map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		String appName = r.getString("appName");
		DateTime deployTime = new DateTime(r.getLong("deployTime"));
		Optional<Boolean> successfullDeploy = Optional.fromNullable(r.getBoolean("successfullDeploy"));
		boolean inProgress = r.getBoolean("inProgress");
		Deploy deploy = new Deploy();
		deploy.setAppName(appName);
		deploy.setDeployTime(deployTime);
		deploy.setInProgress(inProgress);
		deploy.setSuccessfullDeploy(successfullDeploy);
		return deploy;
	}

}
