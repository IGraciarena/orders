package dev.igraciarena.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@JsonPropertyOrder({"id", "total_price", "delivery_cost", "status", "client",
        "address", "items"})
@JsonRootName(value = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "orders")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderClassName = "Builder")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderModel extends RepresentationModel<OrderModel> {
    private Long id;
    @JsonProperty(value = "total_price")
    private BigDecimal totalPrice;
    @JsonProperty(value = "delivery_cost")
    private BigDecimal deliveryCost;
    private String status;
    private ClientModel clientModel;
    private AddressModel addressModel;
    private List<OrderItemModel> items;
}