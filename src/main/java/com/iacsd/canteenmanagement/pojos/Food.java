package com.iacsd.canteenmanagement.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food_info")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(columnDefinition = "varchar(10) default null")
	private String type;
	
	@Column(name = "price_per_unit", columnDefinition = "decimal(10,2) default null")
	private Double pricePerUnit;
	
	@Column(columnDefinition = "varchar(20) default null")
	private String status;
	
	@Column(columnDefinition = "boolean default false")
	private boolean is_dropped;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
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
}
