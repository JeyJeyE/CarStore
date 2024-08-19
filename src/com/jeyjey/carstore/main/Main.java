package com.jeyjey.carstore.main;

import com.jeyjey.carstore.controller.Controller;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();

		String response1 = controller.doAction("ADD_CAR;Toyota;Corolla");
		System.out.println(response1);

		String response2 = controller.doAction("DELETE_CAR;123");
		System.out.println(response2);

		String response3 = controller.doAction("INVALID_COMMAND;");
		System.out.println(response3);
	}
}
