package dev.igraciarena.domain.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Data
@EqualsAndHashCode
@Builder(builderClassName = "Builder")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCreateRequest {
    @JsonProperty(value = "total_price")
    private BigDecimal totalPrice;
    @JsonProperty(value = "delivery_cost")
    private BigDecimal deliveryCost;
    private String status;
    private ClientCreateRequest client;
    private AddressCreateRequest address;
    private List<OrderItemCreateRequest> items;
    @JsonProperty(value = "created_date")
    private Instant createdDate;
    @JsonProperty(value = "modified_date")
    private Instant modifiedDate;
    @JsonProperty(value = "is_active")
    private boolean isActive;
    @JsonProperty(value = "is_deleted")
    private boolean isDeleted;
}
