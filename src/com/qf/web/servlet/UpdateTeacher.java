package com.qf.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import com.qf.domain.Teacher;

import com.qf.service.TeacherService;

import com.qf.service.impl.TeacherServiceImpl;

/**
 * Servlet implementation class UpdateTeacher
 */
@WebServlet("/updateTeacher")
public class UpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String methodname=request.getParameter("method");
		//利用反射技术
		Class<? extends UpdateTeacher> class1 = this.getClass();
		try {
			Method method=class1.getMethod(methodname, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		TeacherService teacherService=new TeacherServiceImpl();
		Teacher teacher=teacherService.findById(id);
		//2放入request域中
		request.setAttribute("teacher", teacher);
		//3转发
		request.getRequestDispatcher("/updateTeacher.jsp").forward(request, response);
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现更新
		Teacher teacher=new Teacher();
		//使用beanUtils
		try {
			BeanUtils.populate(teacher, request.getParameterMap());
			TeacherService teacherService=new TeacherServiceImpl();
			teacherService.update(teacher);
			response.sendRedirect(request.getContextPath()+"/listTeacher");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
