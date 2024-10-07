package com.vn.datn.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_code", length = 10)
    private String productCode;

    @Column(name = "name", length = 50)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @Column(name = "image", length = 255)
    private String productImage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "status")
    private Boolean status;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "favorite", nullable = false)
    private Boolean favorite;
}
