package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.CclasService;
import com.qf.service.impl.CclasServiceImpl;



/**
 * Servlet implementation class DeleteClass
 */
@WebServlet("/deleteClass")
public class DeleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			int id=Integer.parseInt(request.getParameter("classId"));
			CclasService cclasService=new CclasServiceImpl();
			cclasService.delete(id);
			response.getWriter().write("<script type='text/javascript'>alert('删除成功');window.location='listClass';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('删除失败');window.location='listClass';</script>");
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
