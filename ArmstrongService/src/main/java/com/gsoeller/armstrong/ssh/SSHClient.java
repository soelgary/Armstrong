package com.gsoeller.armstrong.ssh;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

import com.gsoeller.armstrong.ArmstrongService.PropertiesLoader;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class SSHClient {

	private Session session;
	private Channel channel;
	public void connect() {
		try {
			JSch jsch = new JSch();

			PropertiesLoader loader = new PropertiesLoader();
			jsch.addIdentity(loader.getProperty("com.gsoeller.public_key"));

			String host = null;
			host = loader.getProperty("com.gsoeller.armstrong.host");

			String user = loader.getProperty("com.gsoeller.armstring.user");

			session = jsch.getSession(user, host, 22);

			UserInfo ui = new MyUserInfo();
			session.setUserInfo(ui);
			session.connect();
			channel = session.openChannel("exec");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void disconnect() {
		channel.disconnect();
		session.disconnect();		
	}
	
	public void executeCommand(String command) {
		try {

			((ChannelExec) channel).setCommand("cd /var/www/tmp && git clone https://github.com/soelgary/Complaints.git");

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
				}
				if (channel.isClosed()) {
					if (in.available() > 0)
						continue;
					System.out.println("exit-status: "
							+ channel.getExitStatus());
					break;
				}
			}
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
