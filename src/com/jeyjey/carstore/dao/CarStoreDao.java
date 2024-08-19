package com.jeyjey.carstore.dao;

import java.util.List;

import com.jeyjey.carstore.entity.Car;

public interface CarStoreDao {
	void addCar(Car car) throws DaoException;

	Car findCar(String brand, String model) throws DaoException;

	void updateCar(Car oldCar, Car newCar) throws DaoException;

	void deleteCar(Car car) throws DaoException;

	List<Car> getAllCars() throws DaoException;
}
