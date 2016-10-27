package ru.itis.kpfu.group11501.solncev.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 05.10.2016.
 */
@WebFilter(filterName = "SecretFilter")
public class SecretFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getSession().getAttribute("current_user") != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
