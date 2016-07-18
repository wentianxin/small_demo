package com.test;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * Created by tianx on 2016/2/27.
 */
@WebServlet(urlPatterns = "/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("doget");
    }
}
