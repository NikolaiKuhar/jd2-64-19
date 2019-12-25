package by.it.academy.comics.web.servlet;

import by.it.academy.comics.service.ComicsService;
import by.it.academy.comics.service.impl.ComicsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/comicbookDelete")
public class ComicsDeleteServlet extends HttpServlet {
    private ComicsService comicsService = ComicsServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        comicsService.deleteComics(Long.valueOf(id));
        resp.sendRedirect(req.getContextPath() + "/comicbookList");

    }

}
