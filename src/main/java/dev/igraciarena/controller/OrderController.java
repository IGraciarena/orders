package dev.igraciarena.controller;

import dev.igraciarena.domain.models.Order;
import dev.igraciarena.service.OrderService;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@RequestMapping("/orders")
@RestController
public class OrderController {
  public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping(value = "/{orderId}")
  public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
    LOGGER.info("Calling OrderService to retrieve order by id: {}", id);
    var order = orderService.getOrderById(id);
    LOGGER.info("Order with id: {} was successfully retrieved", order.id());
    return ResponseEntity.ok(order);
  }
}
