package cz.iba.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.apache.commons.lang3.math.NumberUtils;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number = Optional.ofNullable(req.getParameter("x"))
                .map(x -> NumberUtils.toInt(x, 1))
                .filter(x -> x >= 0)
                .orElse(1);

        req.setAttribute("number", number);
        getServletContext().getRequestDispatcher("/hello.jsp").forward(req, resp);
    }
}