package com.qf.web.servlet;

import java.io.IOException;
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
 * Servlet implementation class AddTeacher
 */
@WebServlet("/addTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//2封装数据
				Teacher teacher=new Teacher();
				try {
					BeanUtils.populate(teacher, request.getParameterMap());
					System.out.println(teacher.toString());
					
					TeacherService teacherService=new TeacherServiceImpl();
					teacherService.add(teacher);
					response.sendRedirect(request.getContextPath()+"/listTeacher");
					
				} catch (Exception e) {
					request.getSession().setAttribute("msg", "添加老师失败");
					response.sendRedirect(request.getContextPath()+"/addTeacher.jsp");
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
