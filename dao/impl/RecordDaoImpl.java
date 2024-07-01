package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DbConnection;
import dao.RecordDao;
import model.Record;

public class RecordDaoImpl implements RecordDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Record r) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into record(member_id, book_id, borrow_date, return_date, return_or_not) values(?,?,null,null,0)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, r.getMember_id());
			ps.setString(2, r.getBook_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Record> selectRecord(String member_id) {
		Connection conn = DbConnection.getDb();
		String SQL = "select * from record where member_id=?";
		Record r = null;
		List l = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, member_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new Record();
				r.setMember_id(rs.getString("member_id"));
				r.setBook_id(rs.getString("book_id"));
				r.setBorrow_date(rs.getString("borrow_date"));
				r.setReturn_date(rs.getString("return_date"));
				r.setReturn_or_not(rs.getInt("return_or_not"));
				l.add(r);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public void update(String member_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Integer> getBorrowCounts() {
		Map<String, Integer> borrowCounts = new HashMap<>();
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT book_id, COUNT(book_id) AS count FROM record GROUP BY book_id";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String bookId = rs.getString("book_id");
				int count = rs.getInt("count");
				borrowCounts.put(bookId, count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return borrowCounts;

	}

}
