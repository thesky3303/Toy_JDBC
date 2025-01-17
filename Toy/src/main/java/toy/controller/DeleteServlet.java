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

@WebServlet ("/std/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int stdNo = Integer.parseInt( req.getParameter("stdNo") );
			StdListService service = new StdListServiceImpl();
			int result = service.stdDelte(stdNo);
			HttpSession session = req.getSession();
			
			if(result > 0 ) {
				session.setAttribute("message", "삭제 되었습니다!");
				resp.sendRedirect("/");
				return;
			};
				session.setAttribute("message", "존재하지 않는 번호 입니다");
				resp.sendRedirect("/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
} //--
