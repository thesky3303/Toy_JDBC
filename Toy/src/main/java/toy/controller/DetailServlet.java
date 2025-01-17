
package toy.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import toy.dto.Std;
import toy.service.StdListService;
import toy.service.StdListServiceImpl;

@WebServlet("/std/detail")
public class DetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int stdNo = Integer.parseInt( req.getParameter("stdNo") );
			StdListService service = new StdListServiceImpl();
			Std std = service.stdDetailView(stdNo);
			
			if(std == null) {
				HttpSession session = req.getSession();
				session.setAttribute("message", "학생이 존재하지 않습니다.");
				resp.sendRedirect("/");
				return;
			}
			req.setAttribute("std", std);
			String path = "/WEB-INF/views/detail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
} //--
