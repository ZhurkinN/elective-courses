package ru.rsreu.electivecourses.controller;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandFactory;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.database.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller of web-application.
 */
public class FrontController extends HttpServlet {

    /**
     * Variable, that defines type of command.
     */
    private CommandFactory commandFactory;

    /**
     * Resourcer for text constants.
     */
    public Resourcer resourcer;

    /**
     * Variable, that implements DAOs.
     */
    private DAOFactory daoFactory;


    /**
     * Initializes different class's variables for processing requests.
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        commandFactory = new CommandFactory();
        daoFactory = DAOFactory.getInstance();
        resourcer = ProjectResourcer.getInstance();
        getServletContext().setAttribute("userDAO", daoFactory.getUserDAO());
        getServletContext().setAttribute("studentDAO", daoFactory.getStudentDAO());
        getServletContext().setAttribute("teacherDAO", daoFactory.getTeacherDAO());
        getServletContext().setAttribute("roleDAO", daoFactory.getRoleDAO());
        getServletContext().setAttribute("administratorDAO", daoFactory.getAdministratorDAO());
        getServletContext().setAttribute("moderatorDAO", daoFactory.getModeratorDAO());
    }

    /**
     * Handles GET requests.
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles POST request
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Defines command, executes command's actions
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException
     * @throws IOException
     */
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

    /**
     * Processes response based on action type and view
     * @param request HTTP request
     * @param response HTTP response
     * @param result view and type of action
     * @throws IOException
     * @throws ServletException
     */
    private void processCommandAction(HttpServletRequest request, HttpServletResponse response, CommandResult result) throws IOException, ServletException {
        if (result.getCommandAction() == ActionType.REDIRECT) {
            response.sendRedirect(result.getView());

        } else if (result.getCommandAction() == ActionType.FORWARD) {
            result.getAttributes().forEach(request::setAttribute);
            request.getRequestDispatcher(result.getView()).forward(request, response);

        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}