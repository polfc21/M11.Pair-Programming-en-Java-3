package com.nivel3.view.utils;

public class Command {
	
	private String title;
	boolean isActive;
	
	public Command(String title) {
		this.title = title;
		this.isActive = false;
	}
	
	public void setActive(boolean active) {
		this.isActive = active;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public String getTitle() {
		return this.title;
	}
}
