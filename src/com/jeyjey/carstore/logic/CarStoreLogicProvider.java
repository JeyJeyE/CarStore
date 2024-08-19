package com.jeyjey.carstore.logic;

public class CarStoreLogicProvider {
	private static final CarStoreLogicProvider instance = new CarStoreLogicProvider();
	private final CarStoreLogic carStoreLogic = new CarStoreLogic();

	private CarStoreLogicProvider() {
	}

	public static CarStoreLogicProvider getInstance() {
		return instance;
	}

	public CarStoreLogic getCarStoreLogic() {
		return carStoreLogic;
	}
}
