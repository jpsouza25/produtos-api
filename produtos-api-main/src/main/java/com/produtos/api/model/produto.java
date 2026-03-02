package com.produtos.api.model;

import com.produtos.api.constants.CategoriaProduto;
import com.produtos.api.constants.StatusProduto;
import com.produtos.api.dto.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_produtos")
public class produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NOME_PRODUTO",nullable = false, length = 50)
    private String nome;

    @Column(name = "DESCRICAO_PRODUTO",nullable = false,columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "PRECO_PRODUTO",nullable = false)
    private int preco;

    @ManyToOne
    @JoinColumn(name = "FORNECEDOR_ID")
    private Fornecedor fornecedor;

    @Column(name = "PRODUTO_STATUS",nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProduto status;

    @Column(name = "CATEGORIA_PRODUTO",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CategoriaProduto categoria;

    public ProdutoDTO toDTO(){
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(id);
        dto.setNome(nome);
        dto.setDescricao(descricao);
        dto.setPreco(preco);
        dto.setStatus(status);
        dto.setCategoria(categoria);

        return dto;
    }


}
