package com.vn.datn.entities;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "address")
    private String address;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "FKel9kyl84ego2otj2accfd8mr7"))
    private User user;


    @Column(name = "status_payment")
    private Integer statusPayment;

    @Column(name = "status_transport")
    private Integer statusTransport;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    // Getters and Setters
    public Order() {
    }

    public Order(Integer orderId, String address, Double amount, String phone, User user, Integer statusPayment, Integer statusTransport, String note, Date orderDate) {
        this.orderId = orderId;
        this.address = address;
        this.amount = amount;
        this.phone = phone;
        this.user = user;
        this.statusPayment = statusPayment;
        this.statusTransport = statusTransport;
        this.note = note;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(Integer statusPayment) {
        this.statusPayment = statusPayment;
    }

    public int getStatusTransport() {
        return statusTransport;
    }

    public void setStatusTransport(int statusTransport) {
        this.statusTransport = statusTransport;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
