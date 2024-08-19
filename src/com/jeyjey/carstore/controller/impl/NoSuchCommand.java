package com.jeyjey.carstore.controller.impl;

import com.jeyjey.carstore.controller.Command;

public class NoSuchCommand implements Command {
	@Override
	public String execute(String request) {
		return "Error: No such command.";
	}
}
