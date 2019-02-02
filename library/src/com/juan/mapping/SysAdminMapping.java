package com.juan.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.juan.db.EntityMapping;
import com.juan.entity.SysAdmin;

public class SysAdminMapping implements EntityMapping {

	@Override
	public Object mapping(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		SysAdmin sysAdmin = new SysAdmin(rs.getInt("adminid"),rs.getString("adminname"),
				rs.getString("password"),rs.getInt("admintype"),rs.getInt("other1"),
				rs.getInt("other2"),rs.getString("other3"),rs.getString("other4"));
		return sysAdmin;
	}
}
