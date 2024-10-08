package com.vn.datn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id") // Thêm ánh xạ cột cho 'category_id'
	private Long categoryId;

	@Column(name = "category_name", length = 50) // Ánh xạ cột cho 'category_name'
	private String categoryName;

	@Column(name = "category_image", length = 255) // Ánh xạ cột cho 'category_image'
	private String categoryImage;
}
