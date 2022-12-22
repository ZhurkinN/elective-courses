package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;

import javax.servlet.http.HttpServletRequest;

public class ShowLoginPageCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        CommandResult commandResult = new CommandResult("/jsp/login.jsp", ActionType.FORWARD);
        return commandResult;
    }
}
