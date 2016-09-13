package com.bank.model;

import org.springframework.data.annotation.Id;

public abstract class BaseEntity {
	
	@Id
	protected String id;
	private long version;
	
	public BaseEntity(){
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	
	
}
