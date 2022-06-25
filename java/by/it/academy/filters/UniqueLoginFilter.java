package by.it.academy.filters;

import by.it.academy.entities.User;
import by.it.academy.services.OnlineStore;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/create_account")
public class UniqueLoginFilter implements Filter {
    private final OnlineStore storeService = new OnlineStore();

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("views/errors/loginErrorPage.jsp");
        final Optional<User> userOptional = storeService.getAllUsers().stream().filter(user -> user.getLogin().equals(servletRequest.getParameter("login"))).findFirst();
        if (userOptional.isPresent()) {
            requestDispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
