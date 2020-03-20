package com.patis.common.employee;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("employeeService")
public class EmployeeServiceImpl implements I_EmployeeService{
	
	@Resource(name="employeeDAO")
	private I_EmployeeDAO employeeDAO;

	@Override
	public int dupleCheckId(String joinId) {
		return employeeDAO.dupleCheckId(joinId);
	}
	
	
}
