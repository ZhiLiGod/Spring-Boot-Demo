package com.zhi.springboot.pojo;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message="User name is empty!")
	@Column(name="name", nullable=true, length=30)
	private String name;
	
	@NotEmpty(message="Password is empty")
	@Length(min=5, message="Password should greater than 6 characters")
	@Column(name="password", nullable=true, length=32)
	private String password;
	
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
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private List<Orders> orders;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", height=" + height + ", sex=" + sex + ", birthday="
				+ birthday + ", sendtime=" + sendtime + ", price=" + price
				+ ", floatprice=" + floatprice + ", doubleprice=" + doubleprice
				+ ", orders=" + orders + "]";
	} 
    
    
}
