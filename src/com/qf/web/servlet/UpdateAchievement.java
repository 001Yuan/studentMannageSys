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

import com.qf.domain.Achievement;
import com.qf.domain.Cclas;
import com.qf.domain.Course;
import com.qf.domain.Student;
import com.qf.service.AchievementService;
import com.qf.service.CclasService;
import com.qf.service.CourseService;
import com.qf.service.StudentService;
import com.qf.service.impl.AchievementServiceImpl;
import com.qf.service.impl.CclasServiceImpl;
import com.qf.service.impl.CourseServiceImpl;
import com.qf.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateAchievement
 */
@WebServlet("/updateAchievement")
public class UpdateAchievement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAchievement() {
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
		Class<? extends UpdateAchievement> class1 = this.getClass();
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
		int achievementid=Integer.parseInt(request.getParameter("id"));
		AchievementService achievementService=new AchievementServiceImpl();
		Achievement achievement=achievementService.findById(achievementid);
		StudentService studentService=new StudentServiceImpl();
		List<Student> student = studentService.findAll();
		request.setAttribute("student", student);
		request.setAttribute("achievement", achievement);
		//2放入request域中
		
		//3转发
		request.getRequestDispatcher("/UpdateAchievement.jsp").forward(request, response);
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现更新
		Achievement achievement=new Achievement();
		
		//使用beanUtils
		try {
			BeanUtils.populate(achievement, request.getParameterMap());
			AchievementService achievementService=new AchievementServiceImpl();
			achievementService.update(achievement);
			response.sendRedirect(request.getContextPath()+"/listAchievement");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
