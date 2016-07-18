package com.test;



import org.apache.log4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.*;

import java.io.IOException;


/**
 * Created by tianx on 2016/3/2.
 */

public class MDCTest implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("deFilter");
         MDC.put("name", "tianxin");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }



}
