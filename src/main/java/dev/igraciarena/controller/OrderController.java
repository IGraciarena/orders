package dev.igraciarena.controller;

import dev.igraciarena.config.OrderModelAssembler;
import dev.igraciarena.domain.dtos.request.OrderCreateRequest;
import dev.igraciarena.domain.models.OrderModel;
import dev.igraciarena.service.OrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@RequestMapping("/orders")
@RestController
public class OrderController {
    public static final Logger LOGGER =
            LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    private final OrderModelAssembler orderModelAssembler;

    public OrderController(final OrderService orderService,
                           final OrderModelAssembler orderModelAssembler) {
        this.orderService = orderService;
        this.orderModelAssembler = orderModelAssembler;
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderModel> getOrderById(
            @PathVariable final Long orderId) {
        LOGGER.info("Calling OrderService to retrieve order by id: {}",
                orderId);
        var response = orderService.getOrderById(orderId);
        LOGGER.info("Order with id: {} was successfully retrieved",
                response.getId());
        return new ResponseEntity<>(orderModelAssembler.toModel(response), OK);
    }

    @PostMapping
    public ResponseEntity<OrderModel> createOrder(
            @RequestBody @Valid final OrderCreateRequest order) {
        LOGGER.info("Calling OrderService to create a new order with body: {}",
                order);
        var response = orderService.saveOrder(order);
        LOGGER.info("Order was created successfully with id: {} ",
                response.getId());
        return new ResponseEntity<>(
                orderModelAssembler.toModel(response), CREATED);
    }
}
