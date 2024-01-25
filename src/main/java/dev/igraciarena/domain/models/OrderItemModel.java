package dev.igraciarena.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@JsonPropertyOrder({"id", "total_price", "delivery_cost", "quantity"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderClassName = "Builder")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemModel extends RepresentationModel<OrderItemModel> {
    private Long id;
    @JsonProperty(value = "total_price")
    private BigDecimal totalPrice;
    @JsonProperty(value = "delivery_cost")
    private BigDecimal deliveryCost;
    private int quantity;
}
