package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2014/12/19.
 */

@ParentPackage("struts-default")
@Namespace("/")
@Results({
        @Result(name="success", location="/index.jsp")
})
public class SayHelloAction extends ActionSupport{

    @Action(value = "hi")
    public String sayHello() throws IOException {

        PrintWriter out = ServletActionContext.getResponse().getWriter();
        out.print("HelloWorld");

        return SUCCESS;
    }

    private String name;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;

        System.out.println(name + "name ");
    }


}
