package com.jeyjey.carstore.dao.impl;

import com.jeyjey.carstore.dao.CarStoreDao;
import com.jeyjey.carstore.dao.DaoException;
import com.jeyjey.carstore.entity.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCarStoreDao implements CarStoreDao {
	private final String filePath;

	public FileCarStoreDao(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void addCar(Car car) throws DaoException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			writer.write(carToString(car));
			writer.newLine();
		} catch (IOException e) {
			throw new DaoException("Error adding car to file", e);
		}
	}

	@Override
	public Car findCar(String brand, String model) throws DaoException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Car car = stringToCar(line);
				if (car.getBrand().equals(brand) && car.getModel().equals(model)) {
					return car;
				}
			}
		} catch (IOException e) {
			throw new DaoException("Error finding car in file", e);
		}
		return null; // Если не найдено
	}

	@Override
	public void updateCar(Car oldCar, Car newCar) throws DaoException {
		List<Car> cars = getAllCars();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Car car : cars) {
				if (car.equals(oldCar)) {
					writer.write(carToString(newCar));
				} else {
					writer.write(carToString(car));
				}
				writer.newLine();
			}
		} catch (IOException e) {
			throw new DaoException("Error updating car in file", e);
		}
	}

	@Override
	public void deleteCar(Car car) throws DaoException {
		List<Car> cars = getAllCars();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Car c : cars) {
				if (!c.equals(car)) {
					writer.write(carToString(c));
					writer.newLine();
				}
			}
		} catch (IOException e) {
			throw new DaoException("Error deleting car from file", e);
		}
	}

	@Override
	public List<Car> getAllCars() throws DaoException {
		List<Car> cars = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				cars.add(stringToCar(line));
			}
		} catch (IOException e) {
			throw new DaoException("Error reading cars from file", e);
		}
		return cars;
	}

	private String carToString(Car car) {
		return car.getBrand() + "," + car.getModel() + "," + car.getPrice(); 
	}

	private Car stringToCar(String line) {
		String[] parts = line.split(",");
		return new Car(parts[0], parts[1], 0, Double.parseDouble(parts[2])); 
	}
}
