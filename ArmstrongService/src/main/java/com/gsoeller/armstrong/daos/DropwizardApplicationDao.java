package com.gsoeller.armstrong.daos;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.gsoeller.armstrong.mappers.DropwizardApplicationMapper;
import com.gsoeller.armstrong.pojos.DropwizardApplication;

public interface DropwizardApplicationDao {

	@SqlQuery("SELECT * FROM DropwizardApplication")
	@Mapper(DropwizardApplicationMapper.class)
	public List<DropwizardApplication> getAllAplications();
	
	@SqlQuery("SELECT * FROM DropwizardApplication where name = :appName limit 1")
	@Mapper(DropwizardApplicationMapper.class)
	public List<DropwizardApplication> getApplication(@Bind("appName") String appName);
	
	@SqlUpdate("INSERT INTO DropwizardApplication (name, deployPath, buildPath, ymlPath) values (:name, :deployPath, :buildPath, :ymlPath)")
	public int addApplication(@Bind("name") String name, @Bind("deployPath") String deployPath, @Bind("buildPath") String buildPath, @Bind("ymlPath") String ymlPath);
}
