package com.produtos.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.produtos.api.dto.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NOME_USUARIO",nullable = false)
    private String nome;

    @Column(name = "CPF_USUARIO",nullable = false, length = 11, unique = true)
    private Double cpf;

    @Column(name = "EMAIL_USUARIO",nullable = false)
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_NASC_USUARIO")
    private LocalDate datadenascimento;

    public UsuarioDTO toDTO(){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(id);
        dto.setNome(nome);
        dto.setEmail(email);
        dto.setDatadenascimento(datadenascimento);
        dto.setCpf(cpf);

        return dto;
    }
}
