package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao {

	public static void main(String[] args) {
		Member m = new Member("A123519615","teacher","1234","teacher","1984-06-30","男","2024-06-30","台北","0912345678");
		new MemberDaoImpl().add(m);
	}

	@Override
	public void add(Member m) {
		Connection conn = DbConnection.getDb();
        if (conn == null) {
            System.out.println("Failed to make connection!");
            return;
        }
		String SQL = "insert into member(identity,account, password, name, birthday, gender,date,address,phone,level) values(?,?,?,?,?,?,?,?,?,'member')";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, m.getIdentity());
			ps.setString(2, m.getAccount());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getName());
			ps.setString(5, m.getBirthday());
			ps.setString(6, m.getGender());
			ps.setString(7, m.getDate());
			ps.setString(8, m.getAddress());
			ps.setString(9, m.getPhone());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	@Override
	public Member checkAccount(String account) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where account=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				m = new Member();
				//m.setId(rs.getInt("id"));
				m.setMember_id(rs.getString("member_id"));
				m.setIdentity(rs.getString("identity"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setBirthday(rs.getString("birthday"));
				m.setGender(rs.getString("gender"));
				m.setDate(rs.getString("date"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setLibrary_card(rs.getString("library_card"));
				m.setLevel(rs.getString("level"));
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
}
