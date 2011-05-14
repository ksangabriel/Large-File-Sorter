package org.lfs.config;

import java.util.ArrayList;
import java.util.Collection;

import org.lfs.common.entity.AbstractEntity;

public class AppContext extends AbstractEntity {
	
	private Collection<Thread> fileThreads = new ArrayList<Thread>();
	private ApplicationConfig applicationConfig = new ApplicationConfig();
	
	public Collection<Thread> getFileThreads() {
		return fileThreads;
	}
	public void setFileThreads(Collection<Thread> fileThreads) {
		this.fileThreads = fileThreads;
	}
	
	public ApplicationConfig getApplicationConfig() {
		return applicationConfig;
	}
	public void setApplicationConfig(ApplicationConfig applicationConfig) {
		this.applicationConfig = applicationConfig;
	}
}
