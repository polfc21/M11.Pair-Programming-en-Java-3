package com.nivel3.view.utils;

public class Session {

	private StateValue stateValue;
	
	public Session() {
		this.stateValue = StateValue.MAIN_MENU;
	}
	
	public StateValue getStateValue() {
		return this.stateValue;
	}

	public void mainMenu() {
		this.stateValue = StateValue.MAIN_MENU;
	}

	public void floristMenu() {
		this.stateValue = StateValue.FLORIST_MENU;
	}
	
	public void addMenu() {
		this.stateValue = StateValue.ADD_MENU;
	}
	
	public void removeMenu() {
		this.stateValue = StateValue.REMOVE_MENU;
	}
	
	public void stockMenu() {
		this.stateValue = StateValue.STOCK_MENU;
	}

	public void shopMenu() { this.stateValue = StateValue.SHOP_MENU; }

	public void purchaseMenu() { this.stateValue = StateValue.PURCHASE_MENU; }
	
	public void exit() {
	        this.stateValue = StateValue.EXIT_APP;
	}
}
