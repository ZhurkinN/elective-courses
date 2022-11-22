package ru.rsreu.electivecourses.command.enums;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.LoginCommand;

public enum CommandType {

    LOGIN("login", LoginCommand.class);

    private String commandName;
    private Class<? extends Command> commandClass;

    CommandType(String commandName, Class<? extends Command> commandClass) {
        this.commandName = commandName;
        this.commandClass = commandClass;
    }

    public static CommandType getCommandType(String commandName) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getCommandName().equals(commandName)) {
                return commandType;
            }
        }
        return CommandType.LOGIN;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Class<? extends Command> getCommandClass() {
        return commandClass;
    }

    public void setCommandClass(Class<? extends Command> commandClass) {
        this.commandClass = commandClass;
    }
}
