package com.zhi.springboot.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Orders implements Serializable {
	@Id
	@GenericGenerator(name="PKUUID", strategy="uuid2")
	@GeneratedValue(generator="PKUUID")
	@Column(length=36, name="oid")
	private String oid;
	
	@Column(name="user_id", length=10, nullable=true)
	private int user_id;
	
	@Column(length=32, name="address", nullable=true)
	private String address;
	
	@Column(length=32, name="phone", nullable=true)
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="user_id", updatable=false,insertable=false,nullable=true)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", user_id=" + user_id + ", address="
				+ address + ", phone=" + phone + "]";
	}
	
	
}
