package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.CommandType;

public class CommandFactory {
    public Command defineCommand(String commandName) throws InstantiationException, IllegalAccessException {
        CommandType type = CommandType.getCommandType(commandName);
        return type.getCommandClass().newInstance();
    }

    public Long defineCommandsRole(String commandName) {
        CommandType type = CommandType.getCommandType(commandName);
        return type.getRoleId();
    }
}
