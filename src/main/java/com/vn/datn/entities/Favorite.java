package com.vn.datn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

    @SuppressWarnings("serial")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Getter
    @Setter
    @Table(name = "favorites")
    public class Favorite implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long favoriteId;

        @ManyToOne()
        @JoinColumn(name = "userId")
        private User user;

        @ManyToOne()
        @JoinColumn(name = "productId")
        private Product product;
}
