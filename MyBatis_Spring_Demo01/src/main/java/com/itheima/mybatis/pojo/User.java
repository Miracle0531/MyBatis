package com.itheima.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>Title: User</p>
 * <p>Description: 用户信息的po类</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智播客
 * @date	2020-12-12
 * @version 1.0
 */
public class User implements Serializable {
	
	private int id;
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址
	
	//订单列表
	private List<Orders> ordersList;
	
	
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address + "]";
	}
	
	

}
