package ru.itis.kpfu.group11501.solncev.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 09.11.2016.
 */
@WebFilter(filterName = "AdminCookieFilter")
public class AdminCookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String login = request.getParameter("login");
        Boolean b = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if ("admin".equals(ck.getName())) {
                    b = true;
                    request.getSession().setAttribute("current_admin", ck.getValue());
                }
            }
        }
        if (b) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/adminlogin");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
