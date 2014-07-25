package com.gsoeller.armstrong.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.gsoeller.armstrong.pojos.DropwizardApplication;

public class DropwizardApplicationMapper implements ResultSetMapper<DropwizardApplication>{

	public DropwizardApplication map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		String name = r.getString("name");
		String buildPath = r.getString("buildPath");
		String deployPath = r.getString("deployPath");
		String ymlPath = r.getString("ymlPath");
		DropwizardApplication app = new DropwizardApplication();
		app.setDeployPath(deployPath);
		app.setBuildPath(buildPath);
		app.setYmlPath(ymlPath);
		app.setName(name);
		return app;
	}

}
