package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.UseParametersRunnerFactory;

import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;


@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 解决乱码问题
		request.setCharacterEncoding("utf-8");//请求乱码
		response.setContentType("text/html;charset=utf-8");//响应乱码
		//2接收数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String validateCode=request.getParameter("validateCode");
		if(username==null||username.trim().equals("")) {
			response.getWriter().write("<script type='text/javascript'>alert('用户名不能为空');window.location='login.jsp'</script>");
			return;
		}
		if(password==null||password.trim().equals("")) {
			response.getWriter().write("<script type='text/javascript'>alert('密码不能为空');window.location='login.jsp'</script>");
			return;
		}
		if(validateCode==null||validateCode.trim().equals("")) {
			response.getWriter().write("<script type='text/javascript'>alert('验证码不能为空');window.location='login.jsp'</script>");
			return;
		}
		
		//3先判断验证码是否正确
		String code=(String) request.getSession().getAttribute("code");
		if(!validateCode.equalsIgnoreCase(code)) {
			response.getWriter().write("验证码错误,2秒钟后跳转到登录页面！");
			response.setHeader("refresh", "2;url=login.jsp");
			return;
		}
		
		//4判断用户名和密码是否正确
		UserService userService=new UserServiceImpl();
		User user=userService.login(username, password);
		if(user==null) {//用户或密码错误
			response.getWriter().write("用户名或密码错误,2秒钟后跳转到登录页面！");
			response.setHeader("refresh", "2;url=login.jsp");
			
		}else {
			//把用户放入session
			request.getSession().setAttribute("user",user );
			request.getRequestDispatcher("/main.jsp").forward(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
