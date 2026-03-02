package com.produtos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.api.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {
    
    Optional<Fornecedor> findByCnpj(String cnpj);

    List<Fornecedor> findByNomeContains(String nome);
}
