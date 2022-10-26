package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApplicationIdentifierFilter implements Filter {
    private final String instanceId = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletResponse instanceof HttpServletResponse httpResponse) {
            httpResponse.setHeader("Instance-Id", this.instanceId);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

}
