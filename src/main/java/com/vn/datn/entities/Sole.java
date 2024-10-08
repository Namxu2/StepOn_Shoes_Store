package com.vn.datn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sole")
public class Sole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sole_id") // Thêm ánh xạ cột cho 'sole_id'
    private int soleId;

    @Column(name = "sole_code", length = 50)
    private String soleCode;

    @Column(name = "sole_name", length = 20)
    private String soleName;

    // Constructors
    public Sole() {}

    public Sole(int id, String soleCode, String soleName) {
        this.soleId = id;
        this.soleCode = soleCode;
        this.soleName = soleName;
    }

    public int getSoleId() {
        return soleId;
    }

    public void setSoleId(int soleId) {
        this.soleId = soleId;
    }

    public String getSoleCode() {
        return soleCode;
    }

    public void setSoleCode(String soleCode) {
        this.soleCode = soleCode;
    }

    public String getSoleName() {
        return soleName;
    }

    public void setSoleName(String soleName) {
        this.soleName = soleName;
    }
}
