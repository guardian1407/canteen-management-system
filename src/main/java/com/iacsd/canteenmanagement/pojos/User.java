package com.iacsd.canteenmanagement.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user_info")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", columnDefinition = "varchar(25) default null")
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "varchar(25) default null")
	private String lastName;
	
	@Column(columnDefinition = "varchar(50) default null")
	private String email;
	
	@Column(columnDefinition = "varchar(100) default null")
	private String address;
	
	@Column(columnDefinition = "varchar(20) default null")
	private String phone;
	
	@Column(columnDefinition = "varchar(20) default null")
	private String type;
	
	@Column(columnDefinition = "varchar(50) default null")
	private String username;
	
	@Column(columnDefinition = "varchar(50) default null")
	private String password;
	
	@Column(columnDefinition = "boolean default false")
	private boolean is_dropped;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Order> orders;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIs_dropped() {
		return is_dropped;
	}

	public void setIs_dropped(boolean is_dropped) {
		this.is_dropped = is_dropped;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
