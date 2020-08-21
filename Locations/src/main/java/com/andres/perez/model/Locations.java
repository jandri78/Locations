package com.andres.perez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Locations {
	
	@Id
	private int id;

	private String name;

	private int area_m2;



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

	public int getArea_m2() {
		return area_m2;
	}

	public void setArea_m2(int area_m2) {
		this.area_m2 = area_m2;
	}


	@Override
	public String toString() {
		return "Locations [id=" + id + ", name=" + name + ", area_m2=" + area_m2 + "]";
	}

}
