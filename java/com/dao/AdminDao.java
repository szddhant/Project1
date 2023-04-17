package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DbConnectionPro;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.util.DbConnectionPro;

public class AdminDao {
	
	public AdminBean authenticate(String email, String password) {
		AdminBean admin = null;
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from AD where ad_email = ? and ad_pwd = ?");
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				admin = new AdminBean();
				admin.setName(rs.getString("ad_name"));
				admin.setAd_id(rs.getInt("ad_id"));
				admin.setEmail(rs.getString("ad_email"));
				admin.setPassword(rs.getString("ad_pwd"));
				admin.setPhone_no(rs.getString("ad_phone_no"));
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
		return admin;
	}
}
