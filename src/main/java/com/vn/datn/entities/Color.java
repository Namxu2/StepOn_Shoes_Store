package com.vn.datn.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colors") // Tên bảng phải khớp với tên trong cơ sở dữ liệu
public class Color implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id") // Tên cột phải khớp với tên cột trong cơ sở dữ liệu
    private Integer colorId;

    @Column(name = "color_code", length = 50) // Đặt tên cột cho thuộc tính 'color_code'
    private String colorCode; // Đổi tên thuộc tính thành 'colorCode' theo chuẩn Java

    @Column(name = "color_name", length = 50) // Đặt tên cột cho thuộc tính 'color_name'
    private String colorName; // Đổi tên thuộc tính thành 'colorName' theo chuẩn Java
}
