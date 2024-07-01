package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.ManagerDao;
import dao.MemberDao;
import model.Manager;
import model.Member;

public class ManagerDaoImpl implements ManagerDao {

	public static void main(String[] args) {
		

	}

	@Override
	public Member selectMember(String account, String password) {
		Connection conn = DbConnection.getDb();
		String SQL = "select * from member where account=? and password=?";
		Member m = null;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				m = new Member();
				m.setMember_id(rs.getString("member_id"));
				m.setIdentity(rs.getString("identity"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setBirthday(rs.getString("birthday"));
				m.setGender(rs.getString("gender"));
				m.setDate(rs.getString("date"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setLibrary_card(rs.getString("library_card"));
				m.setLevel(rs.getString("level"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m;
	}

	@Override
	public void update(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="update member set password=? where member_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getPassword());
			ps.setString(2, m.getMember_id());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from member where member_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getMember_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Manager checkAccount(String account) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from manager where account=?";
		Manager m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				m = new Manager();
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				return m;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<String> getMemberColumnNames() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<String> columnNames = new ArrayList<>();
		
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(SQL);
				ResultSet rs=ps.executeQuery();
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
	public List<Object[]> getMember() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<Object[]> dataList = new ArrayList<>();
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
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
