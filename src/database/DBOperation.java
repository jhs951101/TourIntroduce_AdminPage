package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Member;
import model.Model;

public class DBOperation {
	private DBConnection db;

	public DBOperation() {
		db = DBConnection.getInstance();
	}

	public boolean insert(Model m) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			conn = db.getConnection();
			
			String sql = null;
			
			if(m instanceof Member) 
				sql = "insert into MEMBER values(?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			
			if(m instanceof Member) {
				pstmt.setString(1, ((Member) m).getUsername());
				pstmt.setString(2, ((Member) m).getPassword());
				pstmt.setString(3, ((Member) m).getName());
			}

			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}

	public Model select(String id, Model m) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			
			String sql = null;
			
			if(m instanceof Member)
				sql = "select * from MEMBER where USERNAME=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if(m instanceof Member) {
					return new Member(rs.getString(1), rs.getString(2), rs.getString(3));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public boolean update(Model m) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			String sql = null;
			
			if(m instanceof Member) 
				sql = "update MEMBER set PASSWORD=?, NAME=?"
						+ " where USERNAME=?";
			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);

			if(m instanceof Member) {
				pstmt.setString(1, ((Member) m).getPassword());
				pstmt.setString(2, ((Member) m).getName());
			}
			
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}

	public boolean delete(String id, Model m) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			conn = db.getConnection();
			
			String sql = null;
			
			if(m instanceof Member)
				sql = "delete MEMBER where USERNAME=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return success;
	}
}
