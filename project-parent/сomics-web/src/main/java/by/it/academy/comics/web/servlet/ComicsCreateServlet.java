package by.it.academy.comics.web.servlet;

import by.it.academy.comics.model.Comics;
import by.it.academy.comics.service.ComicsService;
import by.it.academy.comics.service.ComicsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/comicbookCreate")
public class ComicsCreateServlet extends HttpServlet {

    private ComicsService comicsService = ComicsServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/comicbookCreate.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String count = req.getParameter("count");
        String rating = req.getParameter("rating");

        Comics comics = new Comics(null, name, Double.valueOf(price),Integer.valueOf(count),Double.valueOf(rating));
        comicsService.addNewComics(comics);

        resp.sendRedirect(req.getContextPath() + "/comicbookList");
    }
}