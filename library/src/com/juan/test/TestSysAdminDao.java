package com.juan.test;

import java.text.ParseException;

import com.juan.dao.SysAdminDao;
import com.juan.entity.SysAdmin;

public class TestSysAdminDao {

	public static void main(String[] args) throws ParseException {
		SysAdminDao sysAdminDao = new SysAdminDao();
		SysAdmin sysAdmin = new SysAdmin();
		System.out.println(sysAdmin = sysAdminDao.checkUser("admin", "juanjun"));
	}
}
