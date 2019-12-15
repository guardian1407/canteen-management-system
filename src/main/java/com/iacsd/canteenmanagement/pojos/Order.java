package com.iacsd.canteenmanagement.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_info")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "food_item", columnDefinition = "varchar(300) default null")
	private String foodItem;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "timestamp default current_timestamp")
	private Date date;
	
	@Column(columnDefinition = "decimal(10,2) default null")
	private Double amount;
	
	@Column(columnDefinition = "varchar(10) default null")
	private String status;
	
	@Column(columnDefinition = "boolean default false")
	private boolean is_dropped;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public Order() {
		super();
	}

	public Order(String foodItem, Date date, Double amount, String status, User user) {
		super();
		this.foodItem = foodItem;
		this.date = date;
		this.amount = amount;
		this.status = status;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isIs_dropped() {
		return is_dropped;
	}

	public void setIs_dropped(boolean is_dropped) {
		this.is_dropped = is_dropped;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}









