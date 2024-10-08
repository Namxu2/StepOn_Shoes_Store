package com.vn.datn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id") // Tên cột phải trùng khớp với tên cột trong cơ sở dữ liệu
    private Integer brandId; // Tên thuộc tính là 'id'

    @Column(name = "brand_code", length = 50)
    private String brandCode;

    @Column(name = "brand_name", length = 50)
    private String brandName;

    @Column(name = "deleted", columnDefinition = "TINYINT(1)")
    private Boolean deleted;
}
