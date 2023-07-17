package com.qf.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qf.domain.Cclas;
import com.qf.domain.PageBean;
import com.qf.domain.Teacher;
import com.qf.service.CclasService;
import com.qf.service.TeacherService;
import com.qf.service.impl.CclasServiceImpl;
import com.qf.service.impl.TeacherServiceImpl;

/**
 * Servlet implementation class UpdateClass
 */
@WebServlet("/updateClass")
public class UpdateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClass() {
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
		Class<? extends UpdateClass> class1 = this.getClass();
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
		int classId=Integer.parseInt(request.getParameter("classId"));
		CclasService cclasService=new CclasServiceImpl();
		Cclas cclas=cclasService.findById(classId);
		TeacherService teacherService=new TeacherServiceImpl();
		List<Teacher> teacher=teacherService.findAlltname();
		//2把集合放入request域中
		request.setAttribute("teacher", teacher);
		//2放入request域中
		request.setAttribute("cclas", cclas);
		
		//3转发
		request.getRequestDispatcher("/updateClass.jsp").forward(request, response);
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现更新
		Cclas cclas=new Cclas();
		//使用beanUtils
		try {
			BeanUtils.populate(cclas, request.getParameterMap());
			CclasService cclasService=new CclasServiceImpl();
			cclasService.update(cclas);
			response.sendRedirect(request.getContextPath()+"/listClass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
