package com.exemplo.controller;

import com.exemplo.model.Usuario;
import com.exemplo.service.UsuarioService;
import com.exemplo.dto.UsuarioDto;
import com.fasterxml.jackson.databind.ObjectMapper;  // Import necessário
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper; // Para conversão do objeto em JSON

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario salvarUsuario(@Valid @RequestBody UsuarioDto usuarioDto) throws Exception {
        Usuario usuario = usuarioService.salvarUsuario(usuarioDto);


        String usuarioJson = objectMapper.writeValueAsString(usuario);


        rabbitTemplate.convertAndSend("usuarioQueue", usuarioJson);

        return usuario;
    }
}
