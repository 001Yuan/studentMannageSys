package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qf.domain.Course;
import com.qf.service.CourseService;
import com.qf.service.impl.CourseServiceImpl;



/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/addCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
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
				Course course=new Course();
				try {
					BeanUtils.populate(course, request.getParameterMap());
					System.out.println(course.toString());
					
					CourseService courseService=new CourseServiceImpl();
					courseService.add(course);
					response.sendRedirect(request.getContextPath()+"/listCourse");
					
				} catch (Exception e) {
					request.getSession().setAttribute("msg", "添加学生失败");
					response.sendRedirect(request.getContextPath()+"/addCourse.jsp");
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
