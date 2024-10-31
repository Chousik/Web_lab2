package org.chousik.weblab2.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/main")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        execute(req, resp);
    }
    private void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String radius = req.getParameter("r");
        RequestDispatcher dispatcher;
        if (x != null && y != null && radius != null) {
            dispatcher = req.getRequestDispatcher("/area-servlet");
        } else {
            dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
        }
        dispatcher.forward(req, resp);
    }
    public static void sendError(HttpServletResponse resp, String message, int httpServletResponse) throws IOException {
        resp.setContentType("application/json");
        resp.setStatus(httpServletResponse);
        String jsonResponse = "{ \"errorText\": \"" + message + "\" }";
        resp.getWriter().write(jsonResponse);
    }
}
