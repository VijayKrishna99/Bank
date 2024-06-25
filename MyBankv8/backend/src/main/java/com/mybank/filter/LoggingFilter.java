package com.mybank.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.logging.Logger;

public class LoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(LoggingFilter.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Authentication Validation is in progress");
        chain.doFilter(request, response);
    }
}
