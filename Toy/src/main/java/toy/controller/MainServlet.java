package toy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import toy.dto.Std;
import toy.service.StdListService;
import toy.service.StdListServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
      
		try {
			
			StdListService service = new StdListServiceImpl();
			
			Map<String, Object> map = service.stdListFullView();
			
			List<Std> stdList = (List<Std>)map.get("stdList");
			
	
			req.setAttribute("stdList", stdList);
			
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	 
	}
	
	
} //--