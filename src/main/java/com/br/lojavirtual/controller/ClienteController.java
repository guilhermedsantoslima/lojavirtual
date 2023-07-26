package com.br.lojavirtual.controller;

import com.br.lojavirtual.model.ClienteDTO;
import com.br.lojavirtual.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lojavirtual")
public class ClienteController {
    @Autowired
    private ClienteService service;
    @GetMapping
    public List<ClienteDTO> listar(){
        return service.listarTodos();
    }
    @PostMapping
    public ClienteDTO cadastrar(@RequestBody ClienteDTO clienteDTO){
        return service.cadastrarClientes(clienteDTO);
    }
}
