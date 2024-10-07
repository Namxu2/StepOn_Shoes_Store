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
@Table(name = "material")
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Corresponds to `id`

    @Column(name = "material_code", length = 50)
    private String materialCode; // Corresponds to `material_code`

    @Column(name = "material_name", length = 50)
    private String materialName; // Corresponds to `material_name`

    @Column(name = "deleted")
    private Boolean deleted; // Corresponds to `deleted`
}
