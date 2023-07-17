package com.qf.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.Achievement;
import com.qf.domain.Cclas;
import com.qf.domain.Course;
import com.qf.domain.Student;
import com.qf.domain.Teacher;
import com.qf.service.AchievementService;
import com.qf.service.CclasService;
import com.qf.service.CourseService;
import com.qf.service.StudentService;
import com.qf.service.TeacherService;
import com.qf.service.impl.AchievementServiceImpl;
import com.qf.service.impl.CclasServiceImpl;
import com.qf.service.impl.CourseServiceImpl;
import com.qf.service.impl.StudentServiceImpl;
import com.qf.service.impl.TeacherServiceImpl;

/**
 * Servlet implementation class SearchByName
 */
@WebServlet("/searchByName")
public class SearchByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByName() {
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
		Class<? extends SearchByName> class1 = this.getClass();
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
	
	public void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//2获取查询条件
				String searchName=request.getParameter("searchName");
				//3调用业务
				StudentService studentService=new StudentServiceImpl();
				List<Student> stuList=studentService.findBySearch(searchName);
				request.setAttribute("searchName", searchName);
				request.setAttribute("stuList", stuList);
				//4转发
				request.getRequestDispatcher("/listStudent.jsp").forward(request, response);
		
	}
	
	public void searchTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//2获取查询条件
				String searchName=request.getParameter("searchName");
				//3调用业务
				TeacherService teacherService=new TeacherServiceImpl();
				List<Teacher> stuList=teacherService.findBySearch(searchName);
				request.setAttribute("searchName", searchName);
				request.setAttribute("stuList", stuList);
				//4转发
				request.getRequestDispatcher("/listTeacher.jsp").forward(request, response);
		
	}
	
	public void searchClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//2获取查询条件
				String searchName=request.getParameter("searchName");
				//3调用业务
				CclasService teacherService=new CclasServiceImpl();
				List<Cclas> stuList=teacherService.findBySearch(searchName);
				request.setAttribute("searchName", searchName);
				request.setAttribute("stuList", stuList);
				//4转发
				request.getRequestDispatcher("/listClass.jsp").forward(request, response);
		
	}
	
	public void searchCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//2获取查询条件
				String searchName=request.getParameter("searchName");
				//3调用业务
				CourseService courseService=new CourseServiceImpl();
				List<Course> stuList=courseService.findBySearch(searchName);
				request.setAttribute("searchName", searchName);
				request.setAttribute("stuList", stuList);
				//4转发
				request.getRequestDispatcher("/listCourse.jsp").forward(request, response);
		
	}
	
	public void searchAchievement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//2获取查询条件
				String searchName=request.getParameter("searchName");
				//3调用业务
				StudentService studentService=new StudentServiceImpl();
				List<Student> stuList=studentService.findBySearch(searchName);
				AchievementService achievementService=new AchievementServiceImpl();
				List<Achievement> achievement=achievementService.findBySearch(stuList.get(0).getSid());
				request.setAttribute("searchName", searchName);
				request.setAttribute("student", stuList);
				request.setAttribute("stuList", achievement);
				//4转发
				request.getRequestDispatcher("/listAchievement.jsp").forward(request, response);
		
	}


}
