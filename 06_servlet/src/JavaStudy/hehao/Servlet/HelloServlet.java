package JavaStudy.hehao.Servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {


    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

//        1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是:" + servletConfig.getServletName());
//        2、获取初始化参数init-param
        System.out.println("初始化参数username的值是;" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是;" + servletConfig.getInitParameter("url"));

//        1.获取ServletContext对象 域对象
        System.out.println(servletConfig.getServletContext());

//        2.获取web.xml中配置的上下文参数context-param
        System.out.println("当前servletcontext包含的用户是"+servletConfig.getServletContext().getInitParameter("user"));

//        3.获取ServletContext对象真实路径/工程路径
//        System.out.println("当前servletcontext真实路径是"+servletConfig.getServletContext().getContextPath());
        System.out.println("当前servletcontext真实路径是"+servletConfig.getServletContext().getRealPath("/"));

//        4.像map一样存取数据
//        存数据
        servletConfig.getServletContext().setAttribute("key1","value1");
//        一个工程只有一个servlet实例对象
//        工程启动创建
//        工程停止销毁
//        任何servlet均可进行操作，整个web工程都可以进行操作
        System.out.println("context中key1的值是"+servletConfig.getServletContext().getAttribute("key1"));


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === Hello Servlet 被访问了");
        // 类型转换（因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
           doPost();
        }

    }

    /**
     * 做get请求的操作
     */
    public void doGet(){
        System.out.println("get请求");
//        System.out.println("get请求");
    }
    /**
     * 做post请求的操作
     */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 . destroy销毁方法");
    }
}
