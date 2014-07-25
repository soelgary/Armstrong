package com.gsoeller.armstrong.ssh;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.gsoeller.armstrong.ArmstrongService.PropertiesLoader;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class SSHClient {

	private static final String JENKINS_HOST = "jenkins.gsoeller.com";
	private static final String JENKINS_USER = "ubuntu";
	
	public void addRepo(String host, String user, String repoUrl) {
		Commands commands = new Commands();
		commands.setRepoUrl(Optional.of(repoUrl));
		executeCommand(commands.addRepo().get(), host, user);
	}
	
	public void buildCode(String host, String user, String appName, String projectName) {
		Commands commands = new Commands();
		commands.setAppName(Optional.fromNullable(appName));
		commands.setProjectName(Optional.of(projectName));
		executeCommand(commands.buildCode().get(), host, user);
	}
	
	public List<String> getProjects() {
		Commands commands = new Commands();
		return executeCommand(commands.getProjects(), JENKINS_HOST, JENKINS_USER);
	}
	
	private List<String> executeCommand(String command, String host, String user) {
		List<String> output = Lists.newArrayList();
		try {
			Session session;
			Channel channel;
			
			JSch jsch = new JSch();

			PropertiesLoader loader = new PropertiesLoader();
			jsch.addIdentity(loader.getProperty("com.gsoeller.public_key"));

			session = jsch.getSession(user, host, 22);

			UserInfo ui = new MyUserInfo();
			session.setUserInfo(ui);
			session.connect();
			channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);

			// X Forwarding
			// channel.setXForwarding(true);

			// channel.setInputStream(System.in);
			channel.setInputStream(null);

			// channel.setOutputStream(System.out);

			// FileOutputStream fos=new FileOutputStream("/tmp/stderr");
			// ((ChannelExec)channel).setErrStream(fos);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();

			channel.connect();

			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
					output.add(new String(tmp, 0, i).trim());
				}
				if (channel.isClosed()) {
					if (in.available() > 0)
						continue;
					System.out.println("exit-status: "
							+ channel.getExitStatus());
					break;
				}
			}
			channel.disconnect();
			session.disconnect();	
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}
