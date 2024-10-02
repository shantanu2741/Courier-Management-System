package com.cm.util;

public enum CourierStatus {
	In_PickedUp(1,"Picked Up"), 
	In_Transit(2,"In_Transit"), 
	Out_for_Delivery(3,"Out_for_Delivery"), 
	Delivered(4,"Delivered"),
	CANCELLED(5,"Cancelled");


	private Integer id;
	private String name;
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
	private CourierStatus(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
}
