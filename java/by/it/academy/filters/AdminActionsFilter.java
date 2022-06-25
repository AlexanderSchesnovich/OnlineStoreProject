package by.it.academy.filters;

import by.it.academy.entities.UserType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebFilter("/products")
public class AdminActionsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        UserType userType = (UserType) session.getAttribute("userType");
        (userType.equals(UserType.ADMIN)) ? ((HttpServletResponse) servletResponse).sendRedirect(ADMIN_ACTIONS_MENU_PATH) : filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}