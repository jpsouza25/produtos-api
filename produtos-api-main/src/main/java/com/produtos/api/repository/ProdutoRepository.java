package com.produtos.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.api.constants.StatusProduto;
import com.produtos.api.model.produto;

@Repository
public interface ProdutoRepository extends JpaRepository<produto,Long> {
    List<produto> findByNomeLike(String nome);

    List<produto> findByStatus(StatusProduto status);
    
}
