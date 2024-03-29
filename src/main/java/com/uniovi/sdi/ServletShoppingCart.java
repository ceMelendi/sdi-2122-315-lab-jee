package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "ServletShoppingCart", value = "/AddToShoppingCart")
public class ServletShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        HashMap<String, Integer> cart = (HashMap<String, Integer>) request.getSession().getAttribute("cart");

        // No hay carrito, creamos uno y lo insertamos en sesión
        if (cart == null) {
            cart = new HashMap<String, Integer>();
            request.getSession().setAttribute("cart", cart);
        }

        String product = request.getParameter("product");
        if (product != null) {
            addToShoppingCart(cart, product);
        }

        request.setAttribute("selectedItems", cart);
        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    private String shoppingCartToHtml(HashMap<String, Integer> cart) {
        String shoppingCartToHtml = "";

        for (String key : cart.keySet())
            shoppingCartToHtml += "<p>[" + key + "], " + cart.get(key) + " unidades</p>";

        return shoppingCartToHtml;
    }

    private void addToShoppingCart(HashMap<String, Integer> cart, String productKey) {
        if (cart.get(productKey) == null)
            cart.put(productKey, Integer.valueOf(1));
        else {
            int productCount = (Integer) cart.get(productKey).intValue();
            cart.put(productKey, Integer.valueOf(productCount + 1)); //we add a unit
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
