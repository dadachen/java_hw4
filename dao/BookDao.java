package dao;

import java.util.List;

import model.Book;
import model.Member;

public interface BookDao {
	
	void add(Book b);
	void addRecord(String member_id, String book_id);
	
	Book selectBook(String book_id);
	
	List<String> getBookColumnNames();
	List<Object[]> getBook();
	List<Object[]> getBookByMember_id(String member_id);
	List<String> getRecordColumnNames();
	List<Object[]> getRecordByMember_id(String member_id);
	List<Book> selectAll();
	
	void update(Book b);
	void returnBook(String member_id, String book_id);
	
	void delete(Book b);
}
