package com.aop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;
	public EmployeeDAOImpl(DataSource ds){
		dataSource=ds;
	}
	@Override
	public double getSalary(int eno) {
		// TODO Auto-generated method stub
		Connection con=null;
		try{
			con=dataSource.getConnection();
			String sql="selelect sal from emp where empno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, eno);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getDouble(1);
			throw new RuntimeException("Employee Not Found");
		}//try
		catch(Exception e){
		 e.printStackTrace();	
		}//catch
		finally{
			try{con.close();}catch(Exception e){}
		}
		return 0;
	}

	@Override
	public void setSalary(int eno, double sal) {
		// TODO Auto-generated method stub
		Connection con=null;
		try{
			con=dataSource.getConnection();
			String sql="update emp set sal=? where empno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDouble(1, sal);
			ps.setInt(2, eno);
			int count=ps.executeUpdate();
			if(count==1||count==Statement.SUCCESS_NO_INFO)
				return;
		
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){}
		}//finally
		throw new RuntimeException();
	}//setSal

}//class
