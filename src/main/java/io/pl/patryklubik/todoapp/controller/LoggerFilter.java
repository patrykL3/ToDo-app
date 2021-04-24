package io.pl.patryklubik.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Create by Patryk Łubik on 24.04.2021.
 */
@Component
class LoggerFilter implements Filter { // mechanizm javy EE
    private static final Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

    @Override // filtry pozwalają zmieniac requesty / responsy
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            var httpRequest = (HttpServletRequest) request;
            logger.info("[doFilter] " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());
        }
        chain.doFilter(request, response); // wywołanie łąńucha dalszych procesów zatrzymanych poprzednio przez filtr
        // loggera
    }
}
