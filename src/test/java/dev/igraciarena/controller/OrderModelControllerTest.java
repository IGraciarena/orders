package dev.igraciarena.controller;

import dev.igraciarena.config.OrderModelAssembler;
import dev.igraciarena.service.OrderService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static dev.igraciarena.utils.EntityUtils.ORDER_ENTITY_STUB;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@WebMvcTest(controllers = OrderController.class)
class OrderModelControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private OrderModelAssembler orderModelAssembler;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mvc);
    }

    @Test
    @Disabled
    void getOrderById() throws Exception {
        var expected = ORDER_ENTITY_STUB;
        when(orderService.getOrderById(expected.getId())).thenReturn(expected);
        doNothing().when(orderModelAssembler).toModel(expected);
        this.mvc.perform(get("/orders/{orderId}", expected.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id")
                        .value(expected.getId().toString()))
                .andExpect(jsonPath("$.delivery_cost")
                        .value(expected.getDeliveryCost()))
                .andExpect(jsonPath("$.total_price")
                        .value(expected.getTotalPrice()))
                .andExpect(jsonPath("$.status")
                        .value(expected.getStatus()))
                .andExpect(jsonPath("$.client.id")
                        .value(expected.getClient().getId().toString()))
                .andExpect(jsonPath("$.client.first_name")
                        .value(expected.getClient().getFirstName()))
                .andExpect(jsonPath("$.client.last_name")
                        .value(expected.getClient().getLastName()))
                .andExpect(jsonPath("$.address.id")
                        .value(expected.getAddress().getId().toString()))
                .andExpect(jsonPath("$.address.city")
                        .value(expected.getAddress().getCity()))
                .andExpect(jsonPath("$.address.country")
                        .value(expected.getAddress().getCountry()))
                .andExpect(jsonPath("$.address.state")
                        .value(expected.getAddress().getState()))
                .andExpect(jsonPath("$.address.line_number")
                        .value(expected.getAddress().getLineNumber()))
                .andExpect(jsonPath("$.address.postal_code")
                        .value(expected.getAddress().getPostalCode()))
                .andExpect(jsonPath("$.items[0].id")
                        .value(expected.getItems().get(0).getId().toString()))
                .andExpect(jsonPath("$.items[0].total_price")
                        .value(expected.getItems().get(0).getTotalPrice()))
                .andExpect(jsonPath("$.items[0].delivery_cost")
                        .value(expected.getItems().get(0).getDeliveryCost()))
                .andExpect(jsonPath("$.items[0].quantity")
                        .value(expected.getItems().get(0).getQuantity()));
    }
}
