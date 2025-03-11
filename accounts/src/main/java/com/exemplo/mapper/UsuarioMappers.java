package com.exemplo.mapper;

import com.exemplo.model.Usuario;
import com.exemplo.dto.UsuarioDto;


public class UsuarioMappers {

    public static Usuario toEntity( UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword(usuarioDto.getPassword());
        return usuario;
    }

    public static UsuarioDto toDTO( Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setEmail(usuario.getEmail());
        return usuarioDto;
    }
}
