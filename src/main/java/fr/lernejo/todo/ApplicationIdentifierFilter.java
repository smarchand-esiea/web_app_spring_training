package fr.lernejo.todo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {
    String uuid;
    public ApplicationIdentifierFilter() {
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ((HttpServletResponse) servletResponse).setHeader("Instance-Id",this.uuid);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
