package com.juan.entity;

import java.util.Date;

public class BookInfo {
	private int bid;
	private String bookname;
	private String author;
	private int btypeid;
	private String pbname;
	private String context; //ÃèÊö
	private String smallimg;
	private String bigimg;
	private double price;
	private double memberprice;
	private int bookstates; //(1ÒÑÉÏ¼Ü 2Î´ÉÏ¼Ü 3É¾³ý)
	private Date pdate;
	private int other1;
	private int other2;
	private int other3;
	private String other4;
	private String other5;
	private String other6;
	
	public BookInfo(String bookname, int btypeid, String author, String pbname, String context, String smallimg,
			String bigimg, double price, double memberprice, int bookstates, Date pdate, int other1, int other2,
			int other3, String other4, String other5, String other6) {
		super();
		this.bookname = bookname;
		this.btypeid = btypeid;
		this.author = author;
		this.pbname = pbname;
		this.context = context;
		this.smallimg = smallimg;
		this.bigimg = bigimg;
		this.price = price;
		this.memberprice = memberprice;
		this.bookstates = bookstates;
		this.pdate = pdate;
		this.other1 = other1;
		this.other2 = other2;
		this.other3 = other3;
		this.other4 = other4;
		this.other5 = other5;
		this.other6 = other6;
	}
	public BookInfo(int bid, String bookname, int btypeid, String author, String pbname, String context,
			String smallimg, String bigimg, double price, double memberprice, int bookstates, Date pdate, int other1,
			int other2, int other3, String other4, String other5, String other6) {
		super();
		this.bid = bid;
		this.bookname = bookname;
		this.btypeid = btypeid;
		this.author = author;
		this.pbname = pbname;
		this.context = context;
		this.smallimg = smallimg;
		this.bigimg = bigimg;
		this.price = price;
		this.memberprice = memberprice;
		this.bookstates = bookstates;
		this.pdate = pdate;
		this.other1 = other1;
		this.other2 = other2;
		this.other3 = other3;
		this.other4 = other4;
		this.other5 = other5;
		this.other6 = other6;
	}
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBid() {
		return bid;
	}
	public String getBookname() {
		return bookname;
	}
	public int getBtypeid() {
		return btypeid;
	}
	public String getAuthor() {
		return author;
	}
	public String getPbname() {
		return pbname;
	}
	public String getContext() {
		return context;
	}
	public String getSmallimg() {
		return smallimg;
	}
	public String getBigimg() {
		return bigimg;
	}
	public double getPrice() {
		return price;
	}
	public double getMemberprice() {
		return memberprice;
	}
	public int getBookstates() {
		return bookstates;
	}
	public Date getPdate() {
		return pdate;
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
	public void setBid(int bid) {
		this.bid = bid;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public void setBtypeid(int btypeid) {
		this.btypeid = btypeid;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPbname(String pbname) {
		this.pbname = pbname;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public void setSmallimg(String smallimg) {
		this.smallimg = smallimg;
	}
	public void setBigimg(String bigimg) {
		this.bigimg = bigimg;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}
	public void setBookstates(int bookstates) {
		this.bookstates = bookstates;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
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
	public String toString() {
		return "BookInfo [bid=" + bid + ", bookname=" + bookname + ", btypeid=" + btypeid + ", author=" + author
				+ ", pbname=" + pbname + ", context=" + context + ", smallimg=" + smallimg + ", bigimg=" + bigimg
				+ ", price=" + price + ", memberprice=" + memberprice + ", bookstates=" + bookstates + ", pdate="
				+ pdate + ", other1=" + other1 + ", other2=" + other2 + ", other3=" + other3 + ", other4=" + other4
				+ ", other5=" + other5 + ", other6=" + other6 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + bid;
		result = prime * result + ((bigimg == null) ? 0 : bigimg.hashCode());
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + bookstates;
		result = prime * result + btypeid;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		long temp;
		temp = Double.doubleToLongBits(memberprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + other1;
		result = prime * result + other2;
		result = prime * result + other3;
		result = prime * result + ((other4 == null) ? 0 : other4.hashCode());
		result = prime * result + ((other5 == null) ? 0 : other5.hashCode());
		result = prime * result + ((other6 == null) ? 0 : other6.hashCode());
		result = prime * result + ((pbname == null) ? 0 : pbname.hashCode());
		result = prime * result + ((pdate == null) ? 0 : pdate.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((smallimg == null) ? 0 : smallimg.hashCode());
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
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bid != other.bid)
			return false;
		if (bigimg == null) {
			if (other.bigimg != null)
				return false;
		} else if (!bigimg.equals(other.bigimg))
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (bookstates != other.bookstates)
			return false;
		if (btypeid != other.btypeid)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (Double.doubleToLongBits(memberprice) != Double.doubleToLongBits(other.memberprice))
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
		if (pbname == null) {
			if (other.pbname != null)
				return false;
		} else if (!pbname.equals(other.pbname))
			return false;
		if (pdate == null) {
			if (other.pdate != null)
				return false;
		} else if (!pdate.equals(other.pdate))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (smallimg == null) {
			if (other.smallimg != null)
				return false;
		} else if (!smallimg.equals(other.smallimg))
			return false;
		return true;
	}
	
	
	
}
