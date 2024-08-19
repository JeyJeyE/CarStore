package com.jeyjey.carstore.controller.impl;

import com.jeyjey.carstore.controller.Command;
import com.jeyjey.carstore.entity.Car;
import com.jeyjey.carstore.logic.CarStoreLogic;
import com.jeyjey.carstore.logic.CarStoreLogicProvider;

public class UpdateCarCommand implements Command {
	private final CarStoreLogic logic = CarStoreLogicProvider.getInstance().getCarStoreLogic();

	@Override
	public String execute(String request) {
		String[] params = request.split("\n");

		if (params.length < 8) {
			return "Error: Insufficient data provided.";
		}

		try {
			String oldBrand = params[0].trim();
			String oldModel = params[1].trim();
			int oldYear = Integer.parseInt(params[2].trim());
			double oldPrice = Double.parseDouble(params[3].trim());

			String newBrand = params[4].trim();
			String newModel = params[5].trim();
			int newYear = Integer.parseInt(params[6].trim());
			double newPrice = Double.parseDouble(params[7].trim());

			// Проверка на пустые строки
			if (oldBrand.isEmpty() || oldModel.isEmpty() || newBrand.isEmpty() || newModel.isEmpty()) {
				return "Error: Brand and model cannot be empty.";
			}

			Car oldCar = new Car(oldBrand, oldModel, oldYear, oldPrice);
			Car newCar = new Car(newBrand, newModel, newYear, newPrice);

			logic.updateCar(oldCar, newCar);
			return "Car updated successfully.";
		} catch (NumberFormatException e) {
			return "Error: Invalid number format.";
		} catch (Exception e) {
			return "Error: An unexpected error occurred. " + e.getMessage();
		}
	}
}
