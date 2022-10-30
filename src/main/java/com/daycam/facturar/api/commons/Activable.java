package com.daycam.facturar.api.commons;

public interface Activable {
	
	public boolean isEnabled();
	public boolean isDeleted();
	public void setDeleted(Boolean deleted);

}
