package com.jeyjey.carstore.controller.impl;

import com.jeyjey.carstore.controller.Command;
import com.jeyjey.carstore.dao.DaoException;
import com.jeyjey.carstore.entity.Car;
import com.jeyjey.carstore.logic.CarStoreLogic;
import com.jeyjey.carstore.logic.CarStoreLogicProvider;

public class UpdateCar implements Command {
	private final CarStoreLogic logic = CarStoreLogicProvider.getInstance().getCarStoreLogic();

	@Override
	public String execute(String request) {
		try {
			String[] params = request.split("\n");

			if (params.length < 2) {
				return "Error: Insufficient data provided.";
			}

			String brand = params[0].trim();
			String model = params[1].trim();

			if (brand.isEmpty() || model.isEmpty()) {
				return "Error: Brand and model cannot be empty.";
			}

			Car car = logic.findCar(brand, model);
			if (car != null) {
				return "Found car: " + car.getBrand() + " " + car.getModel() + ", Year: " + car.getYear() + ", Price: "
						+ car.getPrice();
			} else {
				return "Car not found.";
			}
		} catch (DaoException e) {
			return "Error: Unable to access the database. " + e.getMessage();
		} catch (Exception e) {
			return "Error: An unexpected error occurred. " + e.getMessage();
		}
	}
}
