package toy.service;

import static toy.common.JDBCTemplate.close;
import static toy.common.JDBCTemplate.commit;
import static toy.common.JDBCTemplate.getConnction;
import static toy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import toy.dao.StdListDAO;
import toy.dao.StdListDAOImpl;
import toy.dto.Std;

public class StdListServiceImpl implements StdListService{

	private StdListDAO dao = new StdListDAOImpl();

	@Override
	public Map<String, Object> stdListFullView() throws Exception {
		Connection conn = getConnction();
		List<Std> stdList = dao.stdListFullView(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stdList", stdList);
		return map;
	}
	
	
	@Override
	public int stdAdd(String stdName, int stdAge, String stdGender, String stdScore) throws Exception {
		Connection conn = getConnction();
		int result = dao.stdAdd(conn, stdName, stdAge, stdGender, stdScore);
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		close(conn);
		return result;
	}
	
	
	@Override
	public Std stdDetailView(int stdNo) throws Exception {
		Connection conn = getConnction();
		Std std = dao.stdDetailView(conn, stdNo);
		close(conn);
		return std;
	}


	@Override
	public int stdDelte(int stdNo) throws Exception {
	Connection conn = getConnction();
		
		int result = dao.stdDelete(conn, stdNo);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}


	@Override
	public int stdUpdate(int stdNo, String stdName, int stdAge, String stdGender, String stdScore) throws Exception {
	
		Connection conn = getConnction();
		
		int result = dao.stdUpdate(conn, stdNo, stdName, stdAge, stdGender, stdScore);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}



	
	
}
