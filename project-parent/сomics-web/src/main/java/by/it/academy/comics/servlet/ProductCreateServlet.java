package by.it.academy.comics.servlet;

import by.it.academy.comics.model.Product;
import by.it.academy.comics.service.ProductService;
import by.it.academy.comics.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productCreate")
public class ProductCreateServlet extends HttpServlet {

    private ProductService productService = ProductServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/productCreate.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String count = req.getParameter("count");
        String rating = req.getParameter("rating");

        Product product = new Product(null, name, Double.valueOf(price),Integer.valueOf(count),Double.valueOf(rating));
        productService.addNewProduct(product);

        resp.sendRedirect(req.getContextPath() + "/productList");
    }
}