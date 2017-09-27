package com.zhi.springboot.pojo;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name", nullable=true, length=30)
	private String name;
	
	@Column(name = "height", nullable = true, length = 10)  
	private int height; 
	
	@Column(name="sex", nullable=true, length=2)
	private int sex;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendtime;
	
	@Column(name="price", nullable=true, length=10)
	private BigDecimal price;
	
	@Column(name = "floatprice", nullable = true, length = 10)  
    private float floatprice;  
  
  
    @Column(name = "doubleprice", nullable = true, length = 10)  
    private double doubleprice;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Date getSendtime() {
		return sendtime;
	}


	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public float getFloatprice() {
		return floatprice;
	}


	public void setFloatprice(float floatprice) {
		this.floatprice = floatprice;
	}


	public double getDoubleprice() {
		return doubleprice;
	}


	public void setDoubleprice(double doubleprice) {
		this.doubleprice = doubleprice;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	} 
    
    
}
