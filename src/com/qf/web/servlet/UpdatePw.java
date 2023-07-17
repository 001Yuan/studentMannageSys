package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpdatePw
 */
@WebServlet("/updatePw")
public class UpdatePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//2获取数据
		String oldpassword = request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String repassword=request.getParameter("repassword");
		
		//3判断原始密码是否正确
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null) {
			if(!user.getPassword().equals(oldpassword)) {
				response.getWriter().write("原始密码有误,2秒钟后跳转到修改密码页面");
				response.setHeader("refresh", "2;url=updatepw.jsp");
				return;
			}
			if(newpassword==null||newpassword.trim().equals("")) {
				response.getWriter().write("新密码不能为空,2秒钟后跳转到修改密码页面");
				response.setHeader("refresh", "2;url=updatepw.jsp");
				return;
			}
			if(!newpassword.equals(repassword)) {
				response.getWriter().write("两次密码不一致,2秒钟后跳转到修改密码页面");
				response.setHeader("refresh", "2;url=updatepw.jsp");
				return;
			}
			
			//更新
			UserService userService=new UserServiceImpl();
			userService.updatePassword(user.getId(),newpassword);
			//把session失效
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			session.invalidate();
			response.getWriter().write("<script type='text/javascript'>alert('密码更新成功,请重新登录');window.location='login.jsp';</script>");

			
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
