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
	
	@SqlUpdate("INSERT INTO DropwizardApplication (name, path) values (:name, :path)")
	public int addApplication(@Bind("name") String name, @Bind("path") String path);
}
