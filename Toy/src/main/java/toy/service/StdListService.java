package toy.service;

import java.util.Map;

import toy.dto.Std;

public interface StdListService {

Map<String, Object> stdListFullView() throws Exception;

int stdAdd(String stdName, int stdAge, String stdGender, String stdScore) throws Exception;

Std stdDetailView(int stdNo) throws Exception;

int stdDelte(int stdNo) throws Exception;

int stdUpdate(int stdNo, String stdName, int stdAge, String stdGender, String stdScore) throws Exception;


}
