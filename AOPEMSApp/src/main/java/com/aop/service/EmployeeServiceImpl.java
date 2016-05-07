package com.aop.service;

import com.aop.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO ed){
		employeeDAO=ed;
	}

	@Override
	public boolean incrementSalary(int empno, double amt) {
		// TODO Auto-generated method stub
		double sal=employeeDAO.getSalary(empno);
		sal+=amt;
		employeeDAO.setSalary(empno, sal);
		System.out.println("updated salary="+sal);
		return true;
	}

}
