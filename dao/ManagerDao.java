package dao;

import java.util.List;

import model.Member;

public interface ManagerDao {
	
	Member selectMember(String account, String password);
	List<String> getMemberColumnNames();
	List<Object[]> getMember();
	
	void update(Member m);
	
	void delete(Member m);
	
	
}
