package pl.patryklubik.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Create by Patryk Łubik on 24.04.2021.
 */
@Component
class LoggerInterceptor implements HandlerInterceptor { // mechanizm springowy
    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override // brak możliwości zmiany request, response i przekazania zmodyfikowanych wartości do dalszych procesów
    // łańcucha
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
        logger.info("[preHandle] " + request.getMethod() + " " + request.getRequestURI());
        return true;
    }
}
