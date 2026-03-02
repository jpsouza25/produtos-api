package com.produtos.api.model;

import com.produtos.api.dto.FornecedorDTO;

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
@Entity(name = "tb_fornecedores")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false,unique = true)
    private String cnpj;

    public FornecedorDTO toDTO(){
        FornecedorDTO dto = new FornecedorDTO();
        dto.setId(id);
        dto.setNome(nome);
        dto.setCnpj(cnpj);
        
        return dto;
    }
}
