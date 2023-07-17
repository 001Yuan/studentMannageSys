package com.qf.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qf.domain.Cclas;
import com.qf.domain.Course;
import com.qf.service.CclasService;
import com.qf.service.CourseService;
import com.qf.service.impl.CclasServiceImpl;
import com.qf.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class UpdateCourse
 */
@WebServlet("/updateCourse")
public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourse() {
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
		Class<? extends UpdateCourse> class1 = this.getClass();
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
		int courseId=Integer.parseInt(request.getParameter("id"));
		CourseService courseService=new CourseServiceImpl();
		Course course=courseService.findById(courseId);
		CclasService cclasService=new CclasServiceImpl();
		List<Cclas> cclas=cclasService.findAlltname();
		//2把集合放入request域中
		request.setAttribute("cclas", cclas);
		request.setAttribute("course", course);
		//2放入request域中
		
		//3转发
		request.getRequestDispatcher("/updateCourse.jsp").forward(request, response);
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现更新
		Course course=new Course();
		//使用beanUtils
		try {
			BeanUtils.populate(course, request.getParameterMap());
			CourseService courseService=new CourseServiceImpl();
			courseService.update(course);
			response.sendRedirect(request.getContextPath()+"/listCourse");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
