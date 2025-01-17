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
			HttpSession session = req.getSession();
			
			if(result > 0 ) {
				session.setAttribute("message", "추가 되었습니다!");
				resp.sendRedirect("/");
				return;
			}
			
			if(result == 0) {
				session.setAttribute("message", "추가 실패 ");
				resp.sendRedirect("/");
				return;
			}

			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
