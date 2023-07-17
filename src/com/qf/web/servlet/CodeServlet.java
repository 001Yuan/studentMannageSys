package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;


@WebServlet("/codeservlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidateCode validateCode=new ValidateCode(180,30,4,30);
		String code=validateCode.getCode();
		validateCode.write(response.getOutputStream());
		//放入session中
		request.getSession().setAttribute("code",code);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
