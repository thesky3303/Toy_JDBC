package toy.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import toy.service.StdListService;
import toy.service.StdListServiceImpl;

@WebServlet("/std/add")
public class AddServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			try {
			
			StdListService service = new StdListServiceImpl();
			
			
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdGender = req.getParameter("stdGender");
			String stdScore = req.getParameter("stdScore");
			
			int result = service.stdAdd(stdName,stdAge,stdGender,stdScore);
			
			String message = null;
			if ( result > 0 ) message = "추가 성공!";
			else			  message = "추가 실패";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}