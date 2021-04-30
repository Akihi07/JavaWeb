package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ShowSutentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = new LinkedList<Student>();
        for (int i = 0; i < 10; i++){
            Integer id = i;
            String name = "name" + i ;
            Integer age  = 10+i % 2;
            String phone = "phone" + i;
            students.add(new Student(id,name,age,phone));
        }
        req.setAttribute("StringList",students);
        req.getRequestDispatcher("/test/student.jsp").forward(req,resp);
    }
}
