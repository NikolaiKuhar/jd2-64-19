package by.it.academy.comics.servlet;

import by.it.academy.comics.service.ProductService;
import by.it.academy.comics.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
    private ProductService productService = ProductServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        productService.deleteProduct(Long.valueOf(id));
        resp.sendRedirect(req.getContextPath() + "/productList");

    }

}
