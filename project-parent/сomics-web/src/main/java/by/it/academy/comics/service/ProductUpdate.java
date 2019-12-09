package by.it.academy.comics.service;

import by.it.academy.comics.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/productUpdate")
public class ProductUpdate extends HttpServlet {
    private ProductService productService = ProductServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String count = req.getParameter("count");
        String rating = req.getParameter("rating");
        String id = req.getParameter("id");
        Product product = new Product(Long.valueOf(id), name, Double.valueOf(price),Integer.valueOf(count),Double.valueOf(rating));
        productService.updateProduct(product);
        resp.sendRedirect(req.getContextPath() + "/productList");
    }


}
