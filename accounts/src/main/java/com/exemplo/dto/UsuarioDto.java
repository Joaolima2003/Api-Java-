package com.exemplo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDto {

    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail não pode estar vazio")
    private String email;

    @NotBlank
    @Size(min = 8, message = "A senha deverá ter no minimo 8 caracters")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
