package com.jeyjey.carstore.controller.impl;

import com.jeyjey.carstore.controller.Command;

public class DeleteCarCommand implements Command {
	@Override
	public String execute(String request) {
		String[] params = request.split(";");
		if (params.length < 2) {
			return "Error: Insufficient data provided.";
		}
		return "Car deleted successfully.";
	}
}
