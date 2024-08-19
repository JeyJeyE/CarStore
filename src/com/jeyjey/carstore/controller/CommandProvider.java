package com.jeyjey.carstore.controller;

import java.util.HashMap;
import java.util.Map;

import com.jeyjey.carstore.controller.impl.AddCarCommand;
import com.jeyjey.carstore.controller.impl.DeleteCarCommand;
import com.jeyjey.carstore.controller.impl.NoSuchCommand;

public class CommandProvider {
    private final Map<String, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put("AddCar", new AddCarCommand());
        repository.put("DeleteCar", new DeleteCarCommand());
        
    }

    public Command getCommand(String commandName) {
        return repository.getOrDefault(commandName, new NoSuchCommand());
    }
}
