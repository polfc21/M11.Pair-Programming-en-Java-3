package com.nivel3.model.domain;

public class ActiveFlorist {
	private static Florist activeFlorist;
	
	public static Florist instance() {
		return activeFlorist;
	}
	
	private ActiveFlorist() {
	}
	
	public static boolean isActiveFlorist() {
		return activeFlorist!=null;
	}
	
	public static void setActiveFlorist(Florist florist) {
		activeFlorist = florist;
	}
}
