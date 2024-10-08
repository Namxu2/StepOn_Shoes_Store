package com.vn.datn.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material") // Tên bảng phải khớp với tên trong cơ sở dữ liệu
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id") // Tên cột phải khớp với tên cột trong cơ sở dữ liệu
    private Long id; // Corresponds to `material_id`

    @Column(name = "material_code", length = 50) // Đặt tên cột cho thuộc tính 'material_code'
    private String materialCode; // Corresponds to `material_code`

    @Column(name = "material_name", length = 50) // Đặt tên cột cho thuộc tính 'material_name'
    private String materialName; // Corresponds to `material_name`

    @Column(name = "deleted") // Ghi chú tên cột cho thuộc tính 'deleted'
    private Boolean deleted; // Corresponds to `deleted`
}
