package ru.rsreu.electivecourses.controller;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandFactory;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private CommandFactory commandFactory;
    public Resourcer resourcer;

    @Override
    public void init() throws ServletException {
        super.init();
        resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter("command");
        try {
            Command command = commandFactory.defineCommand(commandName);
            CommandResult result = command.execute(request);
            processCommandAction(request, response, result);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void processCommandAction(HttpServletRequest request, HttpServletResponse response, CommandResult result) throws IOException, ServletException {
        if (result.getCommandAction() == ActionType.REDIRECT) {
            response.sendRedirect(result.getView());

        } else if (result.getCommandAction() == ActionType.FORWARD) {
            result.getAttributes().forEach(request::setAttribute);
            request.getRequestDispatcher(result.getView()).forward(request, response);

        } else {
            request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        }
    }

}
