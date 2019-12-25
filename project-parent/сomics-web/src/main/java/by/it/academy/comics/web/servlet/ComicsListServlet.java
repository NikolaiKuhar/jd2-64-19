package by.it.academy.comics.web.servlet;

import by.it.academy.comics.model.Comics;
import by.it.academy.comics.service.ComicsService;
import by.it.academy.comics.service.impl.ComicsServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/comicbookList")
public class ComicsListServlet extends HttpServlet {

    private ComicsService comicsService = ComicsServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Comics> allComics = comicsService.getAllComics();
        req.setAttribute("comicbookList", allComics);
        req.getRequestDispatcher("/WEB-INF/jsp/comicbookList.jsp")
                .forward(req, resp);
    }
}