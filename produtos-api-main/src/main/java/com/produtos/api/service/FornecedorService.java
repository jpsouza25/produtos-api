package com.produtos.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.produtos.api.dto.FornecedorDTO;
import com.produtos.api.model.Fornecedor;
import com.produtos.api.repository.FornecedorRepository;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor salvarFornecedor(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public FornecedorDTO buscarFornecedorPeloId(Long id){
        Optional<Fornecedor> fornecedorOpt = fornecedorRepository.findById(id);

        if (fornecedorOpt.isPresent()) {
            return fornecedorOpt.get().toDTO();
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
    }

    public Fornecedor atualizarFornecedor(Long id,Fornecedor dadosFornecedor){
        Optional<Fornecedor> fornecedorOpt = fornecedorRepository.findById(id);

        if (fornecedorOpt.isPresent()) {
            Fornecedor fornecedor = fornecedorOpt.get();

            fornecedor.setNome(dadosFornecedor.getNome());
            fornecedor.setCnpj(dadosFornecedor.getCnpj());

            return fornecedorRepository.save(fornecedor);
        }

        return null;
    }
}
