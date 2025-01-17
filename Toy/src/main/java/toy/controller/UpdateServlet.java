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

@WebServlet("/std/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
				StdListService service = new StdListServiceImpl();
				Std std = service.stdDetailView(stdNo);
				if(std == null) {
					resp.sendRedirect("/");
					return;
				}
			req.setAttribute("std", std);

			String path = "/WEB-INF/views/update.jsp";
			req.getRequestDispatcher(path).forward(req, resp); 
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

		
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdGender = req.getParameter("stdGender");
			String stdScore = req.getParameter("stdScore");
			int stdNo = Integer.parseInt(req.getParameter("stdNo")); // 번호
				
				StdListService service = new StdListServiceImpl();
				int result = service.stdUpdate(stdNo, stdName, stdAge, stdGender,stdScore);
				String url = null;
				String message = null;
				if(result >0) { // 성공
					url = "/std/detail?stdNo=" + stdNo;
					message = "수정 되었습니다";
				} else { // 실패
					url = "/std/update?stdNo=" + stdNo;
					message = "수정 실패";
				}
				req.getSession().setAttribute("message", message);
				resp.sendRedirect(url);
		
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
			
			
} //--

