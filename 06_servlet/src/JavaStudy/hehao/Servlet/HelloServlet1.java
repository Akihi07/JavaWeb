package JavaStudy.hehao.Servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("Hello Servlet");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if(method.equals("GET"))
            doGet();
        else if (method.equals("POST"))
            doPOST();
    }
    // service判断请求方式，执行GET方法
    public void doGet(){
        System.out.println("GET请求被调用");
    }
    // service判断请求方式，执行POST方法
    public void doPOST(){
        System.out.println("POST请求被调用");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
