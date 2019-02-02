package com.juan.entity;

public class SysAdmin {
	private int adminid;
	private String adminname;
	private String password;
	private int admintype;
	private int other1;
	private int other2;
	private String other3;
	private String other4;
	
	public SysAdmin(String adminname, String password, int admintype, int other1, int other2, String other3,
			String other4) {
		super();
		this.adminname = adminname;
		this.password = password;
		this.admintype = admintype;
		this.other1 = other1;
		this.other2 = other2;
		this.other3 = other3;
		this.other4 = other4;
	}
	public SysAdmin(int adminid, String adminname, String password, int admintype, int other1, int other2,
			String other3, String other4) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.password = password;
		this.admintype = admintype;
		this.other1 = other1;
		this.other2 = other2;
		this.other3 = other3;
		this.other4 = other4;
	}
	public SysAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdminid() {
		return adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public String getPassword() {
		return password;
	}
	public int getAdmintype() {
		return admintype;
	}
	public int getOther1() {
		return other1;
	}
	public int getOther2() {
		return other2;
	}
	public String getOther3() {
		return other3;
	}
	public String getOther4() {
		return other4;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAdmintype(int admintype) {
		this.admintype = admintype;
	}
	public void setOther1(int other1) {
		this.other1 = other1;
	}
	public void setOther2(int other2) {
		this.other2 = other2;
	}
	public void setOther3(String other3) {
		this.other3 = other3;
	}
	public void setOther4(String other4) {
		this.other4 = other4;
	}
	@Override
	public String toString() {
		return "SysAdmin [adminid=" + adminid + ", adminname=" + adminname + ", password=" + password + ", admintype="
				+ admintype + ", other1=" + other1 + ", other2=" + other2 + ", other3=" + other3 + ", other4=" + other4
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminid;
		result = prime * result + ((adminname == null) ? 0 : adminname.hashCode());
		result = prime * result + admintype;
		result = prime * result + other1;
		result = prime * result + other2;
		result = prime * result + ((other3 == null) ? 0 : other3.hashCode());
		result = prime * result + ((other4 == null) ? 0 : other4.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysAdmin other = (SysAdmin) obj;
		if (adminid != other.adminid)
			return false;
		if (adminname == null) {
			if (other.adminname != null)
				return false;
		} else if (!adminname.equals(other.adminname))
			return false;
		if (admintype != other.admintype)
			return false;
		if (other1 != other.other1)
			return false;
		if (other2 != other.other2)
			return false;
		if (other3 == null) {
			if (other.other3 != null)
				return false;
		} else if (!other3.equals(other.other3))
			return false;
		if (other4 == null) {
			if (other.other4 != null)
				return false;
		} else if (!other4.equals(other.other4))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
