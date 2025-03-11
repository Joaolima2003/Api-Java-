package com.exemplo.controller;

import com.exemplo.model.Usuario;
import com.exemplo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.exemplo.dto.UsuarioDto;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario salvarUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
        System.out.println("Recebido: Nome=" + usuarioDto.getNome() + ", Email=" + usuarioDto.getEmail());
        return usuarioService.salvarUsuario(usuarioDto);
    }
}
