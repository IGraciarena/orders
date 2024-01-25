package dev.igraciarena.impl;

import dev.igraciarena.repository.OrderRepository;
import dev.igraciarena.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static dev.igraciarena.utils.EntityUtils.ORDER_ENTITY_STUB;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@ExtendWith(MockitoExtension.class)
class OrderModelServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void getOrderById() {
        var expected = ORDER_ENTITY_STUB;
        when(orderRepository.findById(expected.getId()))
                .thenReturn(Optional.of(expected));
        var actual = orderService.getOrderById(expected.getId());
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDeliveryCost())
                .isEqualTo(expected.getDeliveryCost());
        assertThat(actual.getTotalPrice())
                .isEqualTo(expected.getTotalPrice());
        assertThat(actual.getStatus())
                .isEqualTo(expected.getStatus());
        assertThat(actual.getClient().getId())
                .isEqualTo(expected.getClient().getId());
        assertThat(actual.getClient().getFirstName())
                .isEqualTo(expected.getClient().getFirstName());
        assertThat(actual.getClient().getLastName())
                .isEqualTo(expected.getClient().getLastName());
        assertThat(actual.getAddress().getId())
                .isEqualTo(expected.getAddress().getId());
        assertThat(actual.getAddress().getCity())
                .isEqualTo(expected.getAddress().getCity());
        assertThat(actual.getAddress().getCountry())
                .isEqualTo(expected.getAddress().getCountry());
        assertThat(actual.getAddress().getState())
                .isEqualTo(expected.getAddress().getState());
        assertThat(actual.getAddress().getLineNumber())
                .isEqualTo(expected.getAddress().getLineNumber());
        assertThat(actual.getAddress().getPostalCode())
                .isEqualTo(expected.getAddress().getPostalCode());
        assertThat(actual.getItems().get(0).getId())
                .isEqualTo(expected.getItems().get(0).getId());
        assertThat(actual.getItems().get(0).getDeliveryCost())
                .isEqualTo(expected.getItems().get(0).getDeliveryCost());
        assertThat(actual.getItems().get(0).getTotalPrice())
                .isEqualTo(expected.getItems().get(0).getTotalPrice());
        assertThat(actual.getItems().get(0).getQuantity())
                .isEqualTo(expected.getItems().get(0).getQuantity());
    }
}