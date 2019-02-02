package com.juan.entity;

public class BookType {
	private int btypeid;
	private int parentid;
	private String btypename;
	private String isdelete; //1可用的  2逻辑删除  3物理删除 
	private int other1;
	private int other2;
	private int other3;
	private String other4;
	private String other5;
	private String other6;
	
	public BookType(int parentid, String btypename, String isdelete, int other1, int other2, int other3, String other4,
			String other5, String other6) {
		super();
		this.parentid = parentid;
		this.btypename = btypename;
		this.isdelete = isdelete;
		this.other1 = other1;
		this.other2 = other2;
		this.other3 = other3;
		this.other4 = other4;
		this.other5 = other5;
		this.other6 = other6;
	}

	public BookType(int btypeid, int parentid, String btypename, String isdelete, int other1, int other2, int other3,
			String other4, String other5, String other6) {
		super();
		this.btypeid = btypeid;
		this.parentid = parentid;
		this.btypename = btypename;
		this.isdelete = isdelete;
		this.other1 = other1;
		this.other2 = other2;
		this.other3 = other3;
		this.other4 = other4;
		this.other5 = other5;
		this.other6 = other6;
	}

	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getBtypeid() {
		return btypeid;
	}
	public int getParentid() {
		return parentid;
	}
	public String getBtypename() {
		return btypename;
	}
	public String getIsdelete() {
		return isdelete;
	}
	public int getOther1() {
		return other1;
	}
	public int getOther2() {
		return other2;
	}
	public int getOther3() {
		return other3;
	}
	public String getOther4() {
		return other4;
	}
	public String getOther5() {
		return other5;
	}
	public String getOther6() {
		return other6;
	}
	public void setBtypeid(int btypeid) {
		this.btypeid = btypeid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public void setBtypename(String btypename) {
		this.btypename = btypename;
	}
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	public void setOther1(int other1) {
		this.other1 = other1;
	}
	public void setOther2(int other2) {
		this.other2 = other2;
	}
	public void setOther3(int other3) {
		this.other3 = other3;
	}
	public void setOther4(String other4) {
		this.other4 = other4;
	}
	public void setOther5(String other5) {
		this.other5 = other5;
	}
	public void setOther6(String other6) {
		this.other6 = other6;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + btypeid;
		result = prime * result + ((btypename == null) ? 0 : btypename.hashCode());
		result = prime * result + ((isdelete == null ) ? 0 : isdelete.hashCode());
		result = prime * result + other1;
		result = prime * result + other2;
		result = prime * result + other3;
		result = prime * result + ((other4 == null) ? 0 : other4.hashCode());
		result = prime * result + ((other5 == null) ? 0 : other5.hashCode());
		result = prime * result + ((other6 == null) ? 0 : other6.hashCode());
		result = prime * result + parentid;
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
		BookType other = (BookType) obj;
		if (btypeid != other.btypeid)
			return false;
		if (btypename == null) {
			if (other.btypename != null)
				return false;
		} else if (!btypename.equals(other.btypename))
			return false;
		if (isdelete != other.isdelete)
			return false;
		if (other1 != other.other1)
			return false;
		if (other2 != other.other2)
			return false;
		if (other3 != other.other3)
			return false;
		if (other4 == null) {
			if (other.other4 != null)
				return false;
		} else if (!other4.equals(other.other4))
			return false;
		if (other5 == null) {
			if (other.other5 != null)
				return false;
		} else if (!other5.equals(other.other5))
			return false;
		if (other6 == null) {
			if (other.other6 != null)
				return false;
		} else if (!other6.equals(other.other6))
			return false;
		if (parentid != other.parentid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookType [btypeid=" + btypeid + ", parentid=" + parentid + ", btypename=" + btypename + ", isdelete="
				+ isdelete + ", other1=" + other1 + ", other2=" + other2 + ", other3=" + other3 + ", other4=" + other4
				+ ", other5=" + other5 + ", other6=" + other6 + "]";
	}
	
}
