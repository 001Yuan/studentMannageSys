package com.qf.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleMultiInsertStatement.InsertIntoClause;
import com.qf.domain.Cclas;
import com.qf.domain.Student;
import com.qf.domain.Teacher;
import com.qf.service.CclasService;
import com.qf.service.StudentService;
import com.qf.service.TeacherService;
import com.qf.service.impl.CclasServiceImpl;
import com.qf.service.impl.StudentServiceImpl;
import com.qf.service.impl.TeacherServiceImpl;


/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
		Class<? extends UpdateStudent> class1 = this.getClass();
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
		int id=Integer.parseInt(request.getParameter("id"));
		StudentService studentService=new StudentServiceImpl();
		Student student=studentService.findById(id);
		CclasService cclasService=new CclasServiceImpl();
		List<Cclas> cclas=cclasService.findAlltname();
		request.setAttribute("aaaa", cclas);
		//2放入request域中
		request.setAttribute("student", student);
		System.out.print(cclas);
		//3转发
		request.getRequestDispatcher("/updateStudent.jsp").forward(request, response);
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现更新
		Student student=new Student();
		//使用beanUtils
		try {
			BeanUtils.populate(student, request.getParameterMap());
			StudentService studentService=new StudentServiceImpl();
			studentService.update(student);
			response.sendRedirect(request.getContextPath()+"/listStudent");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
