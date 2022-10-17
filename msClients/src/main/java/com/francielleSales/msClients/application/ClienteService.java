package com.francielleSales.msClients.application;

import com.francielleSales.msClients.domain.Cliente;
import com.francielleSales.msClients.exceptions.GenericException;
import com.francielleSales.msClients.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) throws GenericException {

        if (repository.existsByCpf(cliente.getCpf())) {
            throw new GenericException("Esse CPF já está registrado!");
        }

        return repository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf) throws GenericException {

        if (!repository.existsByCpf(cpf)){
            throw new GenericException("Esse CPF não está registrado!");
        }
        return repository.findByCpf(cpf);
    }
}
