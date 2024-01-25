package dev.igraciarena.controller;

import dev.igraciarena.config.OrderModelAssembler;
import dev.igraciarena.domain.models.OrderModel;
import dev.igraciarena.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dev.igraciarena.util.MessageUtils.getCallingServiceMessage;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@RequestMapping("/clients")
@RestController
public class ClientController {

    public static final Logger LOGGER =
            LoggerFactory.getLogger(ClientController.class);
    private final OrderModelAssembler orderModelAssembler;

    private final ClientService clientService;

    public ClientController(final OrderModelAssembler orderModelAssembler,
                            final ClientService clientService) {
        this.orderModelAssembler = orderModelAssembler;
        this.clientService = clientService;
    }

    @GetMapping(value = "/{clientId}/orders")
    public ResponseEntity<CollectionModel<OrderModel>> getOrdersByClientId(
            @PathVariable final Long clientId) {
        LOGGER.info(getCallingServiceMessage(ClientService.class.getName(),
                        "Client"),
                clientId);
        var response = clientService.getAllOrdersByClientId(clientId);
        LOGGER.info("Orders matching Client id: {} were successfully retrieved",
                clientId);
        return new ResponseEntity<>(
                orderModelAssembler.toCollectionModel(response), OK);
    }
}
