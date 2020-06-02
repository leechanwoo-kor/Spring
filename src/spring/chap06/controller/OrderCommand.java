package spring.chap06.controller;

import java.util.List;

import spring.chap06.model.Address;
import spring.chap06.model.OrderItem;

public class OrderCommand {

	private List<OrderItem> orderItems;
	private Address address;
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
