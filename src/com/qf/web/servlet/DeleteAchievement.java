package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.AchievementService;
import com.qf.service.CourseService;
import com.qf.service.impl.AchievementServiceImpl;
import com.qf.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class DeleteAchievement
 */
@WebServlet("/deleteAchievement")
public class DeleteAchievement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAchievement() {
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
			int id=Integer.parseInt(request.getParameter("id"));
			
			AchievementService achievementService=new AchievementServiceImpl();
			achievementService.delete(id);
			
			response.getWriter().write("<script type='text/javascript'>alert('删除成功');window.location='listAchievement';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('删除失败');window.location='listAchievement';</script>");
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
