package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.PageBean;
import com.qf.service.CourseService;
import com.qf.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class ListCourse
 */
@WebServlet("/listCourse")
public class ListCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCourse() {
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
		CourseService courseService=new CourseServiceImpl();
		//获取参数
		String _pageNum=request.getParameter("pageNum");
		String _pageSize=request.getParameter("pageSize");
		String coursename=request.getParameter("coursename");
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
		
		if(coursename==null) {
			coursename="";
		}
		PageBean pageBean = courseService.findByPage(pageNum, pageSize, coursename);
		//2把集合放入request域中
		request.setAttribute("pageBean", pageBean);
		
		//3转发
		request.getRequestDispatcher("/listCourse.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
