package com.dao;

import com.util.DbConnectionPro;

import java.sql.*;
import java.util.ArrayList;

import com.bean.CndBean;
import com.bean.HrBean;

public class CndDao {
	
	public int addCnd(CndBean cndBean) {
		int cnd_id = 0;
		Connection con = null;
		try {
			PreparedStatement pstm = null;
			
			con = DbConnectionPro.getConnection();
			
			pstm = con.prepareStatement("insert into CANDIDATE(cnd_name, cnd_email, cnd_phone_no, cnd_exprnc, cnd_resume_url, cnd_branch) values (?,?,?,?,?,?)");
			
			pstm.setString(1,cndBean.getName());
			pstm.setString(2,cndBean.getEmail());
			pstm.setString(3,cndBean.getPhone());
			pstm.setString(4,cndBean.getExp());
			pstm.setString(5,cndBean.getResume());
			pstm.setString(6,cndBean.getBranch());
			
			int record = pstm.executeUpdate();
			
			pstm = con.prepareStatement("select cnd_id from CANDIDATE where cnd_email = ?");
			pstm.setString(1, cndBean.getEmail());
			
			ResultSet rs  = pstm.executeQuery();
			
			if(rs.next()) {
				cnd_id = rs.getInt("cnd_id");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cnd_id;
	}
	
	
	
	
	
public ArrayList<CndBean> getAllCnd(){
		
		ArrayList<CndBean> cndBean = new ArrayList<CndBean>();
		
		Connection con = null;
		try {
			con = DbConnectionPro.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from CANDIDATE");
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				CndBean cndBean1 = new CndBean();
				cndBean1.setCnd_id(rs.getInt("cnd_id"));
				cndBean1.setName(rs.getString("cnd_name"));
				cndBean1.setPhone(rs.getString("cnd_phone_no"));
				cndBean1.setEmail(rs.getString("cnd_email"));
				cndBean1.setBranch(rs.getString("cnd_branch"));
				cndBean1.setResume(rs.getString("cnd_resume_url"));
				cndBean1.setExp(rs.getString("cnd_exprnc"));
				cndBean.add(cndBean1);
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
		return cndBean;
	} 
	


public void deleteCnd(Integer cnd_id) {
	Connection con = null;
	try {
		con = DbConnectionPro.getConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from CANDIDATE where cnd_id = ?");
		pstmt.setInt(1, cnd_id);
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





public CndBean getCndById(int cnd_id) {
	CndBean cndBean = null;
	Connection con = null;
	try {
		con = DbConnectionPro.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from CANDIDATE where cnd_id ="+cnd_id);
		
//		pstmt.setInt(1, hr_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			cndBean = new CndBean();
			cndBean.setCnd_id(cnd_id);
			cndBean.setName(rs.getString("cnd_name"));
			cndBean.setPhone(rs.getString("cnd_phone_no"));
			cndBean.setEmail(rs.getString("cnd_email"));
			cndBean.setBranch(rs.getString("cnd_branch"));
			cndBean.setResume(rs.getString("cnd_resume_url"));
			cndBean.setExp(rs.getString("cnd_exprnc"));
			return cndBean;
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
	return cndBean;
}




public void editCnd(CndBean cndBean) {
	Connection con = null;
	try {
		con = DbConnectionPro.getConnection();
		PreparedStatement pstmt = con.prepareStatement("update CANDIDATE set cnd_name = ?, cnd_email = ?, cnd_phone_no = ?, cnd_branch = ?, cnd_exprnc = ?, cnd_resume_url = ? where cnd_id = ?");
		
		pstmt.setString(1, cndBean.getName());
		pstmt.setString(2, cndBean.getEmail());
		pstmt.setString(3, cndBean.getPhone());
		pstmt.setString(4, cndBean.getBranch());
		pstmt.setString(5, cndBean.getExp());
		pstmt.setString(6, cndBean.getResume ());
		pstmt.setInt(7, cndBean.getCnd_id());
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





public void addLang(int cnd_id, String[] lang) {
	
	Connection con = DbConnectionPro.getConnection();
	int lngid[] = new int[lang.length];
	
	for(int i=0;i<lang.length;i++)
	{
		String lng = lang[i];
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select lan_id from LANG where lan_name = ?");
			
			ps.setString(1, lng);
			 
			ResultSet rs = ps.executeQuery();
			int tempid = 0;
			if(rs.next())
			{
				tempid = rs.getInt("lan_id");
			}
			
			ps = con.prepareStatement("insert into USER_LANG values(?,?)");
			
			ps.setInt(1, tempid);
			ps.setInt(2, cnd_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}





public void addTech(int cnd_id, String[] tech) {
	
	Connection con = DbConnectionPro.getConnection();
	
	
	for(int i=0;i<tech.length;i++)
	{
		String tech1 = tech[i];
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select tech_id from TECH where tech_name = ?");
			
			ps.setString(1, tech1);
			 
			ResultSet rs = ps.executeQuery();
			int tempTechid = 0;
			if(rs.next())
			{
				tempTechid = rs.getInt("tech_id");
				
			}
			
			ps = con.prepareStatement("insert into USER_TECH values(?,?)");
			
			ps.setInt(1, tempTechid);
			ps.setInt(2, cnd_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}





public void addDb(int cnd_id, String[] db) {
	Connection con = DbConnectionPro.getConnection();
	
	for(int i=0;i<db.length;i++)
	{
		String db1 = db[i];
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select database_id from DB where dbName = ?");
			
			ps.setString(1, db1);
			 
			ResultSet rs = ps.executeQuery();
			int tempDbid = 0;
			if(rs.next())
			{
				tempDbid = rs.getInt("database_id");
				
			}
			
			ps = con.prepareStatement("insert into USER_DB values(?,?)");
			
			ps.setInt(1, tempDbid);
			ps.setInt(2, cnd_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

	
}
