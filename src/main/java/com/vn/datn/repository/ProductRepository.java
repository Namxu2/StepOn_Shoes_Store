package com.vn.datn.repository;

import java.util.List;

import com.vn.datn.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // List product by category
    @Query(value = "SELECT * FROM products WHERE category_id = :categoryId", nativeQuery = true)
    List<Product> listProductByCategory(@Param("categoryId") Long categoryId);

    // Top 10 product by category
    @Query(value = "SELECT * FROM products WHERE category_id = :categoryId LIMIT 10", nativeQuery = true)
    List<Product> listProductByCategory10(@Param("categoryId") Long categoryId);

    // List product new (20 most recent)
    @Query(value = "SELECT * FROM products ORDER BY created_at DESC LIMIT 20", nativeQuery = true)
    List<Product> listProductNew20();

    // Search Product by name
    @Query(value = "SELECT * FROM products WHERE name LIKE %:productName%", nativeQuery = true)
    List<Product> searchProduct(@Param("productName") String productName);

    // Count quantity by product for each category
    @Query(value = "SELECT c.category_id, c.category_name, COUNT(*) AS SoLuong " +
            "FROM products p " +
            "JOIN categories c ON p.category_id = c.category_id " +
            "GROUP BY c.category_name", nativeQuery = true)
    List<Object[]> listCategoryByProductName();

    // Top 20 best selling products
    @Query(value = "SELECT p.product_id, COUNT(*) AS SoLuong " +
            "FROM order_details od " +
            "JOIN products p ON od.product_id = p.product_id " +
            "GROUP BY p.product_id " +
            "ORDER BY SoLuong DESC LIMIT 20", nativeQuery = true)
    List<Object[]> bestSaleProduct20();

    // Find products by inventory IDs
    @Query(value = "SELECT * FROM products WHERE product_id IN :ids", nativeQuery = true)
    List<Product> findByInventoryIds(@Param("ids") List<Long> listProductId);
}
