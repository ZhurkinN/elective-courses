package ru.rsreu.electivecourses.command;

import javax.servlet.http.HttpServletRequest;

public abstract class Command {

    public abstract CommandResult execute(HttpServletRequest request);
}
