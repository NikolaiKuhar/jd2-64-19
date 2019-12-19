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
@WebServlet(urlPatterns = "/comicsbookUpdate")
public class ComicsUpdate extends HttpServlet {
    private ComicsService comicsService = ComicsServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String count = req.getParameter("count");
        String rating = req.getParameter("rating");
        String id = req.getParameter("id");
        Comics comics = new Comics(Long.valueOf(id), name, Double.valueOf(price),Integer.valueOf(count),Double.valueOf(rating));
        comicsService.updateComics(comics);
        resp.sendRedirect(req.getContextPath() + "/comicbookList");
    }


}
