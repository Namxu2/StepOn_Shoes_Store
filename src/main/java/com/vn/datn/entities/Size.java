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
@Table(name = "size")
public class Size implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Corresponds to `id`

    @Column(name = "size_code", length = 50)
    private String sizeCode; // Corresponds to `size_code`

    @Column(name = "size_name", length = 50)
    private String sizeName; // Corresponds to `size_name`
}
