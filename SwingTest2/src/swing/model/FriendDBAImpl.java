package swing.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class FriendDBAImpl implements FriendDBA {
//db연동
	String url,user,pwd;
	public FriendDBAImpl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url="jdbc:oracle:thin:@localhost:1521:xe";
			user="scott";
			pwd="tiger";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//정보등록
	@Override
	public void friendInsert(Friend f) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql="insert into friend values(friend_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			//ps.setInt(5, f.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
		
		
	}
//정보보기
	@Override
	public ArrayList<Friend> friendView() {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<Friend>();
		
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
		
		return arr;
	}
//찾아보기
	@Override
		public ArrayList<Friend> friendsSearch(String str, String word) {
			// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr =new ArrayList<Friend>();
		try {
			con=DriverManager.getConnection(url, user, pwd);
			st=con.createStatement();
			String sql = "select * from friend where " + str + " like '%" + word+"%'";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
			return arr;
		}
//	//특정검색 보기
//	public Friend friendSelect(int num) {
//		Connection con = null;
//		Statement st = null;
//		ResultSet rs = null;
//		Friend f = null;
//		
//		try {
//			con=DriverManager.getConnection(url, user, pwd);
//			String sql = "select * from friend where num="+num;
//			st=con.createStatement();
//			rs=st.executeQuery(sql);
//			if(rs.next())
//			{
//				f = new Friend();
//				f.setNum(rs.getInt("num"));
//				f.setName(rs.getString("name"));
//				f.setBirth(rs.getString("birth"));
//				f.setPhone(rs.getString("phone"));
//				f.setAddr(rs.getString("addr"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return f;
//	}
//	//삭제
//	public void friendDelete(int num) {
//		Connection con = null;
//		Statement st = null;
//		//Friend f = null;
//		
//		try {
//			con=DriverManager.getConnection(url, user, pwd);
//			String sql = "delete from friend where num = "+num;
//			st=con.createStatement();
//			st.executeQuery(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				if(st!=null)st.close();
//				if(con!=null)con.close();
//			}catch(SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//	}

}
