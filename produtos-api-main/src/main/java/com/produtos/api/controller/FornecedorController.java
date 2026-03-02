package com.produtos.api.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.api.dto.FornecedorDTO;
import com.produtos.api.model.Fornecedor;
import com.produtos.api.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> cadastrarFornecedor(@RequestBody Fornecedor fornecedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.salvarFornecedor(fornecedor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> consultarFornecedor(@PathVariable("id") Long id){
        FornecedorDTO fornecedor = fornecedorService.buscarFornecedorPeloId(id);

        if (Objects.isNull(fornecedor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable("id")Long id){
        FornecedorDTO fornecedor = fornecedorService.buscarFornecedorPeloId(id);

        if (Objects.isNull(fornecedor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable("id")Long id,@RequestBody Fornecedor dadosFornecedor){
        FornecedorDTO fornecedor = fornecedorService.buscarFornecedorPeloId(id);

        if (Objects.isNull(fornecedor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.atualizarFornecedor(id, dadosFornecedor));
    }
}
