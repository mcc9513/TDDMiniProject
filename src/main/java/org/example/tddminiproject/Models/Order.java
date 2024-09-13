package org.example.tddminiproject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "ordersTable")  // Changed table name to ordersTable
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Customer name cannot be empty")
    private String customerName;

    private LocalDate orderDate;

    @NotEmpty(message = "Shipping address cannot be empty")
    private String shippingAddress;

    @Positive(message = "Total must be a positive number")
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Customer name cannot be empty") String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(@NotEmpty(message = "Customer name cannot be empty") String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public @NotEmpty(message = "Shipping address cannot be empty") String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(@NotEmpty(message = "Shipping address cannot be empty") String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public @Positive(message = "Total must be a positive number") Double getTotal() {
        return total;
    }

    public void setTotal(@Positive(message = "Total must be a positive number") Double total) {
        this.total = total;
    }
}

