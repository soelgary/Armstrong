package com.gsoeller.armstrong.daos;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.gsoeller.armstrong.mappers.DeployMapper;
import com.gsoeller.armstrong.pojos.Deploy;

public interface DeployDao {
	
	@SqlQuery("SELECT * FROM Deploy")
	@Mapper(DeployMapper.class)
	public List<Deploy> getDeploys();
	
	@SqlUpdate("INSERT INTO Deploy (appName, inProgress, deployTime) values(:appName, :inProgress, :deployTime)")
	public int deploy(@Bind("appName") String appName,  @Bind("inProgress") boolean inProgress, @Bind("deployTime") long deployTime);

}
