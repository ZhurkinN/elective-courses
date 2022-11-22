package ru.rsreu.electivecourses;

import ru.rsreu.electivecourses.model.database.DAOFactory;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + DAOFactory.getInstance().getRoleDAO().getTitleById((long) 2) + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}