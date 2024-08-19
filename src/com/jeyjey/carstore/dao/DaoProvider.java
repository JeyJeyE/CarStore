package com.jeyjey.carstore.dao;

import com.jeyjey.carstore.logic.CarStoreLogic;

public class DaoProvider {
	private static final DaoProvider instance = new DaoProvider();

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return instance;
	}

	public CarStoreDao getCarStoreDao() {
		return new CarStoreDaoImpl();
	}
}
