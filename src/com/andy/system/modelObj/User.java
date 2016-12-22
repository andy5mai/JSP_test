package com.andy.system.modelObj;

public class User implements IRole {
	public User(String strName) {
		this.strName = strName;
	}
	
	private String strName = null;
	
	public void setUserName(String strName) {
		this.strName = strName;
	}
	
	@Override
	public String getName() {
		return this.strName;
	}
}
