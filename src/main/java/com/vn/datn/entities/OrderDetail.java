package com.vn.datn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_detail_id")
	private Long orderDetailId;

	@Column(name = "price")
	private Double price;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", foreignKey = @ForeignKey(name = "FK_order_order_detail"), nullable = true)
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_product_order_detail"), nullable = true)
	private Product product;

	// Getters and Setters
	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
