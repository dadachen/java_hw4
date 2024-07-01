package dao;

import java.util.List;

import model.Member;

public interface MemberDao {

	void add(Member m);
	
	Member selectMember(String account, String password);
	
	void update(Member m);
	
	void delete(Member m);

	Member checkAccount(String account);
	
	
}
