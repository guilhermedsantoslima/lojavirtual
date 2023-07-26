package com.br.lojavirtual.service;

import com.br.lojavirtual.model.ClienteDTO;
import com.br.lojavirtual.model.ClienteEntity;
import com.br.lojavirtual.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public ClienteDTO cadastrarClientes(ClienteDTO clienteDTO){
        ClienteEntity cliente = new ClienteEntity();

        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(clienteDTO.getSenha());

        repository.save(cliente);

        return clienteDTO;
    }
    public List<ClienteDTO> listarTodos(){
        List<ClienteEntity> clienteEntities = repository.findAll();
        List<ClienteDTO> clienteDTOS = new ArrayList<>();

        clienteEntities.forEach(clienteEntity -> {
            ClienteDTO clienteDTO = new ClienteDTO();

            clienteDTO.setEmail(clienteEntity.getEmail());
            clienteDTO.setSenha(clienteEntity.getSenha());

            clienteDTOS.add(clienteDTO);
        });

        return clienteDTOS;
    }
}
