package com.qf.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.domain.Achievement;
import com.qf.domain.Student;
import com.qf.utils.DruidUtils;

/**
 * Servlet implementation class SelectCourse
 */
@WebServlet("/SelectCourse")
public class SelectCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int stuid=Integer.parseInt(request.getParameter("stuid"));
		String coursename = request.getParameter("coursename");
		Achievement achievement;
		QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
		Object[] params= {coursename,stuid};
		try {
			achievement=qr.query("select * from achievement where coursename=? and stuid=? ", new BeanHandler<Achievement>(Achievement.class),params);			
			if(achievement.toString() != null) {
				response.getWriter().write("<script type='text/javascript'>alert('该课程已存在');window.location='listCourse';</script>");
			}

		} catch (NullPointerException e) {
			try {
				qr.update("insert into achievement(coursename,stuid) values(?,?)",params);
				response.getWriter().write("<script type='text/javascript'>alert('选课成功');window.location='listCourse';</script>");
			} catch (Exception e1) {
				response.getWriter().write("<script type='text/javascript'>alert('选课失败');window.location='listCourse';</script>");
			}
		}
		// Object... objs  Object[] objs
		catch (SQLException e) {
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

}
