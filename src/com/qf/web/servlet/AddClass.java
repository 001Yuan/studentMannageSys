package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qf.domain.Cclas;
import com.qf.service.CclasService;
import com.qf.service.impl.CclasServiceImpl;



/**
 * Servlet implementation class AddClass
 */
@WebServlet("/addClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClass() {
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
				//2封装数据
				Cclas cclas=new Cclas();
				try {
					BeanUtils.populate(cclas, request.getParameterMap());
					System.out.println(cclas.toString());
					
					CclasService studentService=new CclasServiceImpl();
					studentService.add(cclas);
					response.sendRedirect(request.getContextPath()+"/listClass");
					
				} catch (Exception e) {
					request.getSession().setAttribute("msg", "添加班级失败");
					response.sendRedirect(request.getContextPath()+"/addClass.jsp");
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
