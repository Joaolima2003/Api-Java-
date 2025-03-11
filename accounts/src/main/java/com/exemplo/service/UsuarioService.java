package com.exemplo.service;

import com.exemplo.model.Usuario;
import com.exemplo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.exemplo.mapper.UsuarioMappers;
import com.exemplo.dto.UsuarioDto;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMappers.toEntity(usuarioDto);
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }
}
