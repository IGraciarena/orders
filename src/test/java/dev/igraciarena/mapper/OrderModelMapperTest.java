package dev.igraciarena.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static dev.igraciarena.utils.EntityUtils.ORDER_ENTITY_STUB;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
class OrderModelMapperTest {

    private final OrderMapper mapper = OrderMapper.INSTANCE;

    @Test
    @Disabled
    void mapOrderEntityToOrderModel() {
        var expected = ORDER_ENTITY_STUB;
        var actual = mapper.mapToModel(expected);
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDeliveryCost())
                .isEqualTo(expected.getDeliveryCost());
        assertThat(actual.getTotalPrice())
                .isEqualTo(expected.getTotalPrice());
        assertThat(actual.getStatus())
                .isEqualTo(expected.getStatus());
        assertThat(actual.getClientModel().getId())
                .isEqualTo(expected.getClient().getId());
        assertThat(actual.getClientModel().getFirstName())
                .isEqualTo(expected.getClient().getFirstName());
        assertThat(actual.getClientModel().getLastName())
                .isEqualTo(expected.getClient().getLastName());
        assertThat(actual.getAddressModel().getId())
                .isEqualTo(expected.getAddress().getId());
        assertThat(actual.getAddressModel().getCity())
                .isEqualTo(expected.getAddress().getCity());
        assertThat(actual.getAddressModel().getCountry())
                .isEqualTo(expected.getAddress().getCountry());
        assertThat(actual.getAddressModel().getState())
                .isEqualTo(expected.getAddress().getState());
        assertThat(actual.getAddressModel().getLineNumber())
                .isEqualTo(expected.getAddress().getLineNumber());
        assertThat(actual.getAddressModel().getPostalCode())
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