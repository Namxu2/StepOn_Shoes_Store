package com.vn.datn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vn.datn.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // List product by category
    @Query(value = "SELECT * FROM products WHERE category_id = :categoryId", nativeQuery = true)
    public List<Product> listProductByCategory(@Param("categoryId") Long categoryId);

    // Top 10 product by category
    @Query(value = "SELECT * FROM products WHERE category_id = :categoryId LIMIT 10", nativeQuery = true)
    List<Product> listProductByCategory10(@Param("categoryId") Long categoryId);

    // List product new
    @Query(value = "SELECT * FROM products ORDER BY created_at DESC LIMIT 20", nativeQuery = true)
    public List<Product> listProductNew20();

    // Search Product
    @Query(value = "SELECT * FROM products WHERE name LIKE %:productName%", nativeQuery = true)
    public List<Product> searchProduct(@Param("productName") String productName);

    // Count quantity by product
    @Query(value = "SELECT c.category_id, c.category_name, COUNT(*) AS SoLuong FROM products p JOIN categories c ON p.category_id = c.category_id GROUP BY c.category_name", nativeQuery = true)
    List<Object[]> listCategoryByProductName();

    // Top 20 product best sale
    @Query(value = "SELECT p.product_id, COUNT(*) AS SoLuong FROM order_details p JOIN products c ON p.product_id = c.product_id GROUP BY p.product_id ORDER BY SoLuong DESC LIMIT 20", nativeQuery = true)
    public List<Object[]> bestSaleProduct20();

    @Query(value = "SELECT * FROM products o WHERE product_id IN :ids", nativeQuery = true)
    List<Product> findByInventoryIds(@Param("ids") List<Long> listProductId); // Change Integer to Long
}
