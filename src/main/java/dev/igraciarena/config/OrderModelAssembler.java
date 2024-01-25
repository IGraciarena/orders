package dev.igraciarena.config;

import dev.igraciarena.controller.ClientController;
import dev.igraciarena.controller.OrderController;
import dev.igraciarena.domain.entities.AddressEntity;
import dev.igraciarena.domain.entities.ClientEntity;
import dev.igraciarena.domain.entities.OrderEntity;
import dev.igraciarena.domain.entities.OrderItemEntity;
import dev.igraciarena.domain.models.AddressModel;
import dev.igraciarena.domain.models.ClientModel;
import dev.igraciarena.domain.models.OrderItemModel;
import dev.igraciarena.domain.models.OrderModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Component
public class OrderModelAssembler
        extends RepresentationModelAssemblerSupport<OrderEntity, OrderModel> {

    public OrderModelAssembler() {
        super(OrderController.class, OrderModel.class);
    }

    @Override
    public OrderModel toModel(final OrderEntity order) {
        OrderModel orderModel = instantiateModel(order);
        orderModel.add(linkTo(
                methodOn(OrderController.class)
                        .getOrderById(orderModel.getId())
        ).withSelfRel());

        orderModel.setId(order.getId());
        orderModel.setTotalPrice(order.getTotalPrice());
        orderModel.setDeliveryCost(order.getDeliveryCost());
        orderModel.setStatus(order.getStatus());
        orderModel.setItems(toOrderModel(order.getItems()));
        orderModel.setClientModel(toOrderModel(order.getClient()));
        orderModel.setAddressModel(toOrderModel(order.getAddress()));
        return orderModel;
    }

    @Override
    public CollectionModel<OrderModel> toCollectionModel(
            final Iterable<? extends OrderEntity> orders) {
        CollectionModel<OrderModel> orderModels =
                super.toCollectionModel(orders);

        var clientId = orderModels.getContent()
                .stream().findFirst().get().getClientModel().getId();

        return orderModels.add(linkTo(methodOn(ClientController.class)
                .getOrdersByClientId(clientId))
                .withSelfRel());
    }

    private List<OrderItemModel> toOrderModel(
            final List<OrderItemEntity> orderItems) {
        if (orderItems.isEmpty()) {
            return Collections.emptyList();
        }

        return orderItems.stream()
                .map(orderItem ->
                        OrderItemModel.builder()
                                .id(orderItem.getId())
                                .totalPrice(orderItem.getTotalPrice())
                                .deliveryCost(orderItem.getDeliveryCost())
                                .quantity(orderItem.getQuantity())
                                .build()
                                .add(linkTo(
                                        methodOn(OrderController.class)
                                                .getOrderById(
                                                        orderItem.getId()))
                                        .withSelfRel()))
                .collect(Collectors.toList());
    }

    private ClientModel toOrderModel(final ClientEntity client) {
        return ClientModel.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .build()
                .add(linkTo(
                        methodOn(OrderController.class)
                                .getOrderById(client.getId()))
                        .withSelfRel());
    }

    private AddressModel toOrderModel(final AddressEntity address) {
        return AddressModel.builder()
                .id(address.getId())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build()
                .add(linkTo(
                        methodOn(OrderController.class)
                                .getOrderById(address.getId())
                ).withSelfRel());
    }
}
