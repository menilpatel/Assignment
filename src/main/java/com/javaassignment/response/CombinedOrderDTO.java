package com.javaassignment.response;

import java.util.Date;

public class CombinedOrderDTO {
	private int id;
	private int productId;
	private double amount = 0.0;
	private Boolean isDeleted = false;
	private Date createdAt = new Date();
	private Date updatedAt = new Date();

	public CombinedOrderDTO() {
	}

	public CombinedOrderDTO(int id, int productId, double amount, Boolean isDeleted, Date createdAt, Date updatedAt) {
		this.id = id;
		this.productId = productId;
		this.amount = amount;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
