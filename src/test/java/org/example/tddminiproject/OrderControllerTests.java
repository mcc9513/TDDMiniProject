package org.example.tddminiproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateOrder() throws Exception {
        String orderJson = "{\"customerName\":\"John Doe\",\"orderDate\":\"2024-09-12\",\"shippingAddress\":\"123 Main St\",\"total\":100.0}";

        mockMvc.perform(post("/api/orders")
                        .contentType("application/json")
                        .content(orderJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateOrder() throws Exception {
        // First create an order before trying to update it
        String orderJson = "{\"customerName\":\"John Doe\",\"orderDate\":\"2024-09-12\",\"shippingAddress\":\"123 Main St\",\"total\":100.0}";

        mockMvc.perform(post("/api/orders")
                        .contentType("application/json")
                        .content(orderJson))
                .andExpect(status().isCreated());

        // Now perform the update operation
        String updatedOrderJson = "{\"customerName\":\"Jane Doe\",\"orderDate\":\"2024-09-12\",\"shippingAddress\":\"456 Elm St\",\"total\":150.0}";

        mockMvc.perform(put("/api/orders/1")  // Assuming the order ID is 1
                        .contentType("application/json")
                        .content(updatedOrderJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOrder() throws Exception {
        // First create an order before trying to delete it
        String orderJson = "{\"customerName\":\"John Doe\",\"orderDate\":\"2024-09-12\",\"shippingAddress\":\"123 Main St\",\"total\":100.0}";

        mockMvc.perform(post("/api/orders")
                        .contentType("application/json")
                        .content(orderJson))
                .andExpect(status().isCreated());

        // Now perform the delete operation
        mockMvc.perform(delete("/api/orders/1"))  // Assuming the order ID is 1
                .andExpect(status().isNoContent());
    }
}
