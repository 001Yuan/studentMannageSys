
package com.qf.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.PageBean;
import com.qf.domain.Student;
import com.qf.service.StudentService;
import com.qf.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ListStudent
 */
@WebServlet("/listStudent")
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//1查询
		StudentService studentService=new StudentServiceImpl();
		//获取参数
		String _pageNum=request.getParameter("pageNum");
		String _pageSize=request.getParameter("pageSize");
		String sname=request.getParameter("sname");
		int pageNum=0;
		int pageSize=0;
		
		if(_pageNum==null||_pageNum.trim().equals("")) {
			pageNum=1;
		}else {
			pageNum=Integer.parseInt(_pageNum);
			if(pageNum<=0) {
				pageNum=1;
			}
			
		}
		if(_pageSize==null || _pageSize.trim().equals("")) {
			pageSize=5;
		}else {
			pageSize=Integer.parseInt(_pageSize);
		}
		
		if(sname==null) {
			sname="";
		}
		PageBean pageBean = studentService.findByPage(pageNum, pageSize, sname);
		//2把集合放入request域中
		request.setAttribute("pageBean", pageBean);
		//3转发
		request.getRequestDispatcher("/listStudent.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
