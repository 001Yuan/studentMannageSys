package com.qf.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qf.domain.Student;
import com.qf.service.StudentService;
import com.qf.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//2封装数据
		Student student=new Student();
		try {
			BeanUtils.populate(student, request.getParameterMap());
			System.out.println(student.toString());
			
			StudentService studentService=new StudentServiceImpl();
			studentService.add(student);
			response.sendRedirect(request.getContextPath()+"/listStudent");
			
		} catch (Exception e) {
			request.getSession().setAttribute("msg", "添加学生失败");
			response.sendRedirect(request.getContextPath()+"/addStudent.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
