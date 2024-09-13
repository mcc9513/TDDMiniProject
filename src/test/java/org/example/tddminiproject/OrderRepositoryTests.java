package org.example.tddminiproject;

import org.example.tddminiproject.Models.Order;
import org.example.tddminiproject.Repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTests {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveOrder() {
        Order order = new Order();
        order.setCustomerName("John Doe");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("123 Main St");
        order.setTotal(100.0);

        Order savedOrder = orderRepository.save(order);

        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getId()).isNotNull();
    }

    @Test
    public void testFindOrderById() {
        // First save an order
        Order order = new Order();
        order.setCustomerName("Jane Doe");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("456 Elm St");
        order.setTotal(150.0);

        orderRepository.save(order);

        // Now retrieve it by ID
        Order foundOrder = orderRepository.findById(order.getId()).orElse(null);

        assertThat(foundOrder).isNotNull();
        assertThat(foundOrder.getCustomerName()).isEqualTo("Jane Doe");
    }

    @Test
    public void testDeleteOrder() {
        // First save an order
        Order order = new Order();
        order.setCustomerName("Mark Smith");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("789 Oak St");
        order.setTotal(200.0);

        orderRepository.save(order);

        // Now delete it
        orderRepository.deleteById(order.getId());

        assertThat(orderRepository.findById(order.getId())).isEmpty();
    }
}
