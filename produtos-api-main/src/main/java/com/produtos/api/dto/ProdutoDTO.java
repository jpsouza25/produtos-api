package com.produtos.api.dto;

import com.produtos.api.constants.CategoriaProduto;
import com.produtos.api.constants.StatusProduto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private int preco;
    private StatusProduto status;
    private CategoriaProduto categoria;    
}
