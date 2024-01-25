package dev.igraciarena.utils;

import dev.igraciarena.domain.dtos.request.AddressCreateRequest;
import dev.igraciarena.domain.dtos.request.ClientCreateRequest;
import dev.igraciarena.domain.dtos.request.OrderCreateRequest;
import dev.igraciarena.domain.dtos.request.OrderItemCreateRequest;
import dev.igraciarena.domain.entities.AddressEntity;
import dev.igraciarena.domain.entities.ClientEntity;
import dev.igraciarena.domain.entities.OrderEntity;
import dev.igraciarena.domain.entities.OrderItemEntity;
import dev.igraciarena.domain.models.AddressModel;
import dev.igraciarena.domain.models.ClientModel;
import dev.igraciarena.domain.models.OrderItemModel;
import dev.igraciarena.domain.models.OrderModel;

import java.math.BigDecimal;
import java.util.List;

import static dev.igraciarena.util.ConstantUtil.NOW;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public final class EntityUtils {

    public static final AddressEntity ADDRESS_ENTITY_STUB =
            AddressEntity.builder()
                    .id(1L)
                    .city("Mar del Plata")
                    .state("Buenos Aires")
                    .country("Argentina")
                    .lineNumber("0115962339")
                    .postalCode("7600")
                    .build();
    public static final AddressModel
            ADDRESS_MODEL_MODEL_STUB = AddressModel.builder()
            .id(ADDRESS_ENTITY_STUB.getId())
            .lineNumber(ADDRESS_ENTITY_STUB.getLineNumber())
            .city(ADDRESS_ENTITY_STUB.getCity())
            .state(ADDRESS_ENTITY_STUB.getState())
            .country(ADDRESS_ENTITY_STUB.getCountry())
            .postalCode(ADDRESS_ENTITY_STUB.getPostalCode())
            .build();
    public static final AddressCreateRequest ADDRESS_CREATE_REQUEST_STUB =
            AddressCreateRequest.builder()
                    .lineNumber(ADDRESS_ENTITY_STUB.getLineNumber())
                    .city(ADDRESS_ENTITY_STUB.getCity())
                    .country(ADDRESS_ENTITY_STUB.getCountry())
                    .state(ADDRESS_ENTITY_STUB.getState())
                    .postalCode(ADDRESS_ENTITY_STUB.getPostalCode())
                    .isActive(ADDRESS_ENTITY_STUB.isActive())
                    .isDeleted(ADDRESS_ENTITY_STUB.isDeleted())
                    .createdDate(ADDRESS_ENTITY_STUB.getCreatedDate())
                    .modifiedDate(ADDRESS_ENTITY_STUB.getModifiedDate())
                    .build();
    private static final BigDecimal TOTAL_PRICE_DOUBLE =
            BigDecimal.valueOf(200.00);
    private static final BigDecimal DELIVERY_DISCOUNT_DOUBLE =
            BigDecimal.valueOf(100.00);
    public static final OrderItemEntity ORDER_ITEM_ENTITY_STUB =
            OrderItemEntity.builder()
                    .id(1L)
                    .totalPrice(TOTAL_PRICE_DOUBLE)
                    .deliveryCost(DELIVERY_DISCOUNT_DOUBLE)
                    .quantity(2)
                    .build();
    public static final OrderItemModel
            ORDER_ITEM_MODEL_STUB = OrderItemModel.builder()
            .id(ORDER_ITEM_ENTITY_STUB.getId())
            .totalPrice(ORDER_ITEM_ENTITY_STUB.getTotalPrice())
            .deliveryCost(ORDER_ITEM_ENTITY_STUB.getDeliveryCost())
            .quantity(ORDER_ITEM_ENTITY_STUB.getQuantity())
            .build();
    public static final OrderItemCreateRequest ORDER_ITEM_CREATE_REQUEST_STUB =
            OrderItemCreateRequest.builder()
                    .deliveryCost(ORDER_ITEM_ENTITY_STUB.getDeliveryCost())
                    .quantity(ORDER_ITEM_ENTITY_STUB.getQuantity())
                    .totalPrice(ORDER_ITEM_ENTITY_STUB.getTotalPrice())
                    .isActive(ORDER_ITEM_ENTITY_STUB.isActive())
                    .isDeleted(ORDER_ITEM_ENTITY_STUB.isDeleted())
                    .createdDate(ORDER_ITEM_ENTITY_STUB.getCreatedDate())
                    .modifiedDate(ORDER_ITEM_ENTITY_STUB.getModifiedDate())
                    .build();
    private static final ClientEntity CLIENT_ENTITY_STUB =
            ClientEntity.builder()
                    .id(1L)
                    .firstName("John")
                    .lastName("Doe")
                    .build();
    public static final OrderEntity ORDER_ENTITY_STUB = OrderEntity.builder()
            .id(1L)
            .deliveryCost(DELIVERY_DISCOUNT_DOUBLE)
            .totalPrice(TOTAL_PRICE_DOUBLE)
            .status("DELIVERED")
            .client(CLIENT_ENTITY_STUB)
            .address(ADDRESS_ENTITY_STUB)
            .items(List.of(ORDER_ITEM_ENTITY_STUB))
            .isActive(TRUE)
            .isDeleted(FALSE)
            .createdDate(NOW)
            .modifiedDate(NOW)
            .build();
    public static final ClientModel CLIENT_MODEL_MODEL_STUB = ClientModel
            .builder()
            .id(CLIENT_ENTITY_STUB.getId())
            .firstName(CLIENT_ENTITY_STUB.getFirstName())
            .lastName(CLIENT_ENTITY_STUB.getLastName())
            .build();
    public static final OrderModel ORDER_MODEL_STUB = OrderModel.builder()
            .id(1L)
            .totalPrice(TOTAL_PRICE_DOUBLE)
            .deliveryCost(DELIVERY_DISCOUNT_DOUBLE)
            .status(ORDER_ENTITY_STUB.getStatus())
            .clientModel(CLIENT_MODEL_MODEL_STUB)
            .addressModel(ADDRESS_MODEL_MODEL_STUB)
            .items(List.of(ORDER_ITEM_MODEL_STUB))
            .build();
    public static final ClientCreateRequest CLIENT_CREATE_REQUEST_STUB =
            ClientCreateRequest.builder()
                    .firstName(CLIENT_ENTITY_STUB.getFirstName())
                    .lastName(CLIENT_ENTITY_STUB.getLastName())
                    .isActive(CLIENT_ENTITY_STUB.isActive())
                    .isDeleted(CLIENT_ENTITY_STUB.isDeleted())
                    .createdDate(CLIENT_ENTITY_STUB.getCreatedDate())
                    .modifiedDate(CLIENT_ENTITY_STUB.getModifiedDate())
                    .build();
    public static final OrderCreateRequest ORDER_CREATE_REQUEST_STUB =
            OrderCreateRequest.builder()
                    .status(ORDER_ENTITY_STUB.getStatus())
                    .totalPrice(ORDER_ENTITY_STUB.getTotalPrice())
                    .deliveryCost(ORDER_ENTITY_STUB.getDeliveryCost())
                    .items(List.of(ORDER_ITEM_CREATE_REQUEST_STUB))
                    .client(CLIENT_CREATE_REQUEST_STUB)
                    .address(ADDRESS_CREATE_REQUEST_STUB)
                    .isActive(ORDER_ENTITY_STUB.isActive())
                    .isDeleted(ORDER_ENTITY_STUB.isDeleted())
                    .createdDate(ORDER_ENTITY_STUB.getCreatedDate())
                    .modifiedDate(ORDER_ENTITY_STUB.getModifiedDate())
                    .build();
    private EntityUtils() {

    }
}
