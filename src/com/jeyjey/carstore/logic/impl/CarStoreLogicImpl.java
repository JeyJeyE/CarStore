package com.jeyjey.carstore.logic.impl;

import com.jeyjey.carstore.dao.CarStoreDao;
import com.jeyjey.carstore.dao.DaoException;
import com.jeyjey.carstore.entity.Car;

import java.util.List;

public class CarStoreLogicImpl implements CarStoreLogic { 
	private final CarStoreDao dao;

	public CarStoreLogicImpl(CarStoreDao dao) {
		this.dao = dao;
	}

	public void addCar(Car car) throws DaoException {
		dao.addCar(car);
	}

	public Car findCar(String brand, String model) throws DaoException {
		return dao.findCar(brand, model);
	}

	public void updateCar(Car oldCar, Car newCar) throws DaoException {
		dao.updateCar(oldCar, newCar);
	}

	public void deleteCar(Car car) throws DaoException {
		dao.deleteCar(car);
	}

	public List<Car> getAllCars() throws DaoException {
		return dao.getAllCars();
	}
}
