package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jun Young Won
 */
public class HelloWorldServlet extends HttpServlet {


    @Override
    /*doGet says take this and display this jsp (which is the helloWorldForm*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                .forward(request, response);
    }

    @Override
    /*Does the doPost from the form that connected through web.xml*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Gets the parameter from the form*/
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        /*sets the parameters and set as attributes so its available in jsp*/
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        /*forwards to sayHello.jsp*/
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request, response);
    }

}
