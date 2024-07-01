package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.BookDao;
import dao.DbConnection;
import model.Book;
import model.Member;

public class BookDaoImpl implements BookDao {

	public static void main(String[] args) {

		// List<String> columnNames = new BookDaoImpl().getColumnNames();
		// System.out.println(Arrays.toString(columnNames.toArray()));
		// List<Object[]> dataList = new BookDaoImpl().getAllData();
		// System.out.println(Arrays.toString(dataList.toArray()));
		/*
		 * Connection conn=DbConnection.getDb(); String SQL="select * from book";
		 * ArrayList l=new ArrayList();
		 * 
		 * PreparedStatement ps; try { ps = conn.prepareStatement(SQL); ResultSet
		 * rs=ps.executeQuery(); ResultSetMetaData md=rs.getMetaData(); int
		 * cc=md.getColumnCount(); //System.out.print(cc); while (rs.next()){ HashMap
		 * row = new HashMap(cc); for(int i=1; i<=cc; i++){
		 * row.put(md.getColumnName(i),rs.getObject(i));
		 * 
		 * //l.add(rs.getMetaData().getColumnName(i)); } l.add(row); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * try { List l= new BookDaoImpl().resultSetToArrayList();
		 * System.out.println(Arrays.toString(l.toArray()));
		 * l.forEach(System.out::println); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	public List resultSetToArrayList() throws SQLException {
		Connection conn = DbConnection.getDb();
		String SQL = "select * from book";

		PreparedStatement ps;
		ps = conn.prepareStatement(SQL);
		ResultSet rs1 = ps.executeQuery();
		ResultSetMetaData md = rs1.getMetaData();
		int columns = md.getColumnCount();
		ArrayList list = new ArrayList(50);
		while (rs1.next()) {
			HashMap row = new HashMap(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs1.getObject(i));
			}
			list.add(row);
		}

		return list;
	}

	@Override
	public void add(Book b) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into book(book_name, accession_number, isbn, author, publisher, publication_date) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, b.getBook_name());
			ps.setString(2, b.getAccession_number());
			ps.setString(3, b.getIsbn());
			ps.setString(4, b.getAuthor());
			ps.setString(5, b.getPublisher());
			ps.setString(6, b.getPublication_date());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Book selectBook(String book_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL = "select * from book";
		List<Book> l = new ArrayList();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setBook_id(rs.getString("book_id"));
				b.setBook_name(rs.getString("book_name"));
				b.setAccession_number(rs.getString("accession_number"));
				b.setIsbn(rs.getString("isbn"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublication_date(rs.getString("publisher"));

				l.add(b);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public void update(Book b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Book b) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getBookColumnNames() {

		Connection conn = DbConnection.getDb();
		String SQL = "select * from book";
		List<String> columnNames = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				columnNames.add(metaData.getColumnName(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return columnNames;
	}

	@Override
	public List<Object[]> getBook() {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT b.* FROM book AS b LEFT JOIN ( SELECT DISTINCT book_id FROM record WHERE return_or_not = 0) AS r ON b.book_id = r.book_id WHERE r.book_id IS NULL";
		List<Object[]> dataList = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = rs.getObject(i);
				}
				dataList.add(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataList;
	}

	@Override
	public void addRecord(String member_id, String book_id) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into record(member_id,book_id,borrow_date,return_date,return_or_not) values(?,?,?,null,'0')";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, member_id);
			ps.setString(2, book_id);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(3, df.format(new Date()));
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Object[]> getBookByMember_id(String member_id) {
		Connection conn = DbConnection.getDb();
		String SQL = "select b.* from book as b left join record as r on b.book_id=r.book_id where r.return_or_not = '0' and r.member_id=?";
		List<Object[]> dataList = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, member_id);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = rs.getObject(i);
				}
				dataList.add(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataList;
	}

	@Override
	public void returnBook(String member_id, String book_id) {
		Connection conn = DbConnection.getDb();
		String SQL = "update record set return_date=? ,return_or_not='1' where member_id=? and book_id=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(1, df.format(new Date()));
			ps.setString(2, member_id);
			ps.setString(3, book_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<String> getRecordColumnNames() {
		Connection conn = DbConnection.getDb();
		String SQL = "select * from record";
		List<String> columnNames = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				columnNames.add(metaData.getColumnName(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return columnNames;
	}

	@Override
	public List<Object[]> getRecordByMember_id(String member_id) {
		Connection conn = DbConnection.getDb();
		String SQL = "select * from record where member_id=?";
		List<Object[]> dataList = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, member_id);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = rs.getObject(i);
				}
				dataList.add(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataList;
	}

}
