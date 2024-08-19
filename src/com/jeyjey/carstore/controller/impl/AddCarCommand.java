package com.jeyjey.carstore.controller.impl;

import com.jeyjey.carstore.controller.Command;

public class AddCarCommand implements Command {
	public String execute(String request) {
		return "Car added successfully.";
	}
}
