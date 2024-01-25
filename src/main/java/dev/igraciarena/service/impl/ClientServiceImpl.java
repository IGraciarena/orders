package dev.igraciarena.service.impl;

import dev.igraciarena.domain.entities.OrderEntity;
import dev.igraciarena.exception.EntityNotFoundException;
import dev.igraciarena.repository.ClientRepository;
import dev.igraciarena.service.ClientService;
import dev.igraciarena.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.igraciarena.exception.EntityError.CLIENT_NOT_FOUND;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final OrderService orderService;

    public ClientServiceImpl(final ClientRepository clientRepository,
                             final OrderService orderService) {
        this.clientRepository = clientRepository;
        this.orderService = orderService;
    }

    @Override
    public List<OrderEntity> getAllOrdersByClientId(final Long clientId) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(
                        () -> new EntityNotFoundException(CLIENT_NOT_FOUND));
        return orderService.findAllByClientId(client.getId());
    }
}
