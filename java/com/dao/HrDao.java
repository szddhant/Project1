package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.AdminBean;
import com.bean.HrBean;
import com.util.DbConnectionPro;






public class HrDao {
	
	
	
	
	
	
	public HrBean authenticate(String email, String password) {
		HrBean hrBean = null;
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from HR where hr_email = ? and hr_pwd = ?");
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				hrBean = new HrBean();
				hrBean.setName(rs.getString("hr_name"));
				hrBean.setHr_id(rs.getInt("hr_id"));
				hrBean.setEmail(rs.getString("hr_email"));
				hrBean.setPassword(rs.getString("hr_pwd"));
				hrBean.setPhone(rs.getString("hr_phone_no"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
	}
			finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hrBean;
	}
	
	
	
	
	
	public void addHr(HrBean hrBean) {
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			
			PreparedStatement pstm = con.prepareStatement("insert into HR(hr_name,hr_email,hr_pwd,hr_phone_no) values (?,?,?,?)");
			
			pstm.setString(1,hrBean.getName());
			pstm.setString(2,hrBean.getEmail());
			pstm.setString(3,hrBean.getPassword());
			pstm.setString(4,hrBean.getPhone());
			
			int record = pstm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public ArrayList<HrBean> getAllHr(){
		
		ArrayList<HrBean> hrBean = new ArrayList<HrBean>();
		
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from HR");
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				HrBean hrBean1 = new HrBean();
				hrBean1.setHr_id(rs.getInt("hr_id"));
				hrBean1.setName(rs.getString("hr_name"));
				hrBean1.setPassword(rs.getString("hr_pwd"));
				hrBean1.setEmail(rs.getString("hr_email"));
				hrBean1.setPhone(rs.getString("hr_phone_no"));
				hrBean.add(hrBean1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hrBean;
	}
	
	
	
	
	
	public void deleteHr(Integer hr_id) {
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from HR where hr_id = ?");
			pstmt.setInt(1, hr_id);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	public void editHr(HrBean hrBean) {
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update HR set hr_name = ?, hr_pwd = ?, hr_email = ?, hr_phone_no = ? where hr_id = ?");
			
			pstmt.setString(1, hrBean.getName());
			pstmt.setString(2, hrBean.getPassword());
			pstmt.setString(3, hrBean.getEmail());
			pstmt.setString(4, hrBean.getPhone());
			pstmt.setInt(5, hrBean.getHr_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public HrBean getHrById(int hr_id) {
		HrBean hrBean = null;
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from HR where hr_id ="+hr_id);
			
//			pstmt.setInt(1, hr_id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				hrBean = new HrBean();
				hrBean.setHr_id(hr_id);
				hrBean.setName(rs.getString("hr_name"));
				hrBean.setPhone(rs.getString("hr_phone_no"));
				hrBean.setEmail(rs.getString("hr_email"));
				hrBean.setPassword(rs.getString("hr_pwd"));
				return hrBean;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return hrBean;
	}
	
	
	
}
