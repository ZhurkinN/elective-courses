package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;

import javax.servlet.http.HttpServletRequest;

public class ShowLoginPageCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult("/JSP/login.jsp", ActionType.FORWARD);
    }
}
