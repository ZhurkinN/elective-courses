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
import java.io.PrintWriter;

public class FrontController extends HttpServlet {

    private CommandFactory commandFactory;
    public Resourcer resourcer;
    private DAOFactory daoFactory;

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
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + DAOFactory.getInstance().getUserDAO().getUserByLogin((String) request.getParameter("login")).getName() + "</h1>");
//        out.println("</body></html>");
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
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
