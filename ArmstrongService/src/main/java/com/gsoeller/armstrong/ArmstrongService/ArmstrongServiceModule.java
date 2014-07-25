package com.gsoeller.armstrong.ArmstrongService;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.gsoeller.armstrong.ssh.SSHClient;

public class ArmstrongServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SSHClient.class).in(Singleton.class);
	}
}
