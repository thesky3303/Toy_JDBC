package toy.dao;

import java.sql.Connection;
import java.util.List;

import toy.dto.Std;

public interface StdListDAO {

	List<Std> stdListFullView(Connection conn) throws Exception;

	int stdAdd(Connection conn, String stdName, int stdAge, String stdGender, String stdScore) throws Exception;

	Std stdDetailView(Connection conn, int stdNo) throws Exception;

	int stdDelete(Connection conn, int stdNo) throws Exception;

	int stdUpdate(Connection conn, int stdNo, String stdName, int stdAge, String stdGender, String stdScore) throws Exception;

}
