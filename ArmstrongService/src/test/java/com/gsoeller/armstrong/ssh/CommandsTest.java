package com.gsoeller.armstrong.ssh;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.mockito.runners.MockitoJUnitRunner;  

import com.google.common.base.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CommandsTest {

	private Commands commands;
	
	@Before
	public void setup() {
		commands = new Commands();
	}
	
	@Test
	public void testItHasNoDeployDirectory() {
		assertFalse(commands.getDeployDirectory().isPresent());
	}
	
	@Test
	public void testItHasNoBuildDirectory() {
		assertFalse(commands.getBuildDirectory().isPresent());
	}
	
	@Test
	public void testItHasNoRepUrl() {
		assertFalse(commands.getRepoUrl().isPresent());
	}
	
	@Test
	public void testItHasADeployDirectory() {
		String appName = "ArmstrongService";
		String deployDirectory = String.format("%s/%s", "cd /var/www", appName);
		commands.setAppName(Optional.of(appName));
		assertEquals(deployDirectory, commands.getDeployDirectory().get());
	}
	
	@Test
	public void testItHasABuildDirectory() {
		String projectName = "ArmstrongService";
		String appName = "Armstrong";
		String buildDirectory = String.format("%s/%s/%s", "cd /var/build", appName, projectName);
		commands.setAppName(Optional.of(appName));
		commands.setProjectName(Optional.of(projectName));
		assertEquals(buildDirectory, commands.getBuildDirectory().get());
	}
	
	@Test
	public void testItHasARepoUrl() {
		String repoUrl = "Armstrong";
		String cloneCommand = String.format("%s %s", "git clone", repoUrl);
		commands.setRepoUrl(Optional.of(repoUrl));
		assertEquals(cloneCommand, commands.getRepoUrl().get());
	}
	
	@Test
	public void testBuildCode() {
		String projectName = "ArmstrongService";
		String appName = "Armstrong";
		String buildDirectory = String.format("%s/%s/%s", "cd /var/build", appName, projectName);
		commands.setAppName(Optional.of(appName));
		commands.setProjectName(Optional.of(projectName));
		String buildCode = "mvn package";
		assertEquals(String.format("%s && %s", buildDirectory, buildCode), commands.buildCode().get());
	}
	
	@Test 
	public void testUpdateCode() {
		String projectName = "Armstrong";
		String buildDirectory = String.format("%s/%s", "cd /var/build", projectName);
		commands.setProjectName(Optional.of(projectName));
		String updateCode = "git pull origin master";
		assertEquals(String.format("%s && %s", buildDirectory, updateCode), commands.updateCode().get());
	}
}
