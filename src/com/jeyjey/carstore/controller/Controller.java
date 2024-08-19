package com.jeyjey.carstore.controller;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	private final String paramDelimiter = ";";

	public String doAction(String request) {
		int delimiterIndex = request.indexOf(paramDelimiter);
		if (delimiterIndex == -1) {
			return "Error: Invalid request format.";
		}
		String commandName = request.substring(0, delimiterIndex);
		Command executionCommand = provider.getCommand(commandName.toUpperCase());

		return executionCommand.execute(request);
	}
}
