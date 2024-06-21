package com.javaassignment.response;

import java.util.Date;

public class CombinedOrder {
	private Long id;
	private Long productId;
	private Double amount;
	private Boolean isDeleted;
	private Date createdAt;
	private Date updatedAt;

	// Constructor
	public CombinedOrder(Long id, Long productId, Double amount, Boolean isDeleted, Date createdAt, Date updatedAt) {
		this.id = id;
		this.productId = productId;
		this.amount = amount;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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
