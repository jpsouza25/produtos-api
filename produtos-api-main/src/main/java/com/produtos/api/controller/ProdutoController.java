package com.produtos.api.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.api.constants.StatusProduto;
import com.produtos.api.dto.ProdutoDTO;
import com.produtos.api.model.produto;
import com.produtos.api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    //@Valid
    @PostMapping
    public ResponseEntity<produto> cadastrarProduto(@RequestBody produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> consultarProduto(@PathVariable("id") Long id){
        ProdutoDTO produto = produtoService.buscarProdutoPeloId(id);

        if (Objects.isNull(produto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable("id")Long id){
        ProdutoDTO produto = produtoService.buscarProdutoPeloId(id);

        if (Objects.isNull(produto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        produtoService.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<produto> atualizarProduto(@PathVariable("id") Long id,@RequestBody produto dadosProduto){
        ProdutoDTO produto = produtoService.buscarProdutoPeloId(id);

        if (Objects.isNull(produto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarProduto(id, dadosProduto));
    }

    @GetMapping("/busca")
    public ResponseEntity<List<ProdutoDTO>> filtrarProdutosCujoNomeComecaCom(@RequestParam("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.filtrarProdutosCujoNomeComecaCom(nome));
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<ProdutoDTO>> filtarProdutosPeloStatus(@RequestParam(name = "status",defaultValue = "DISPONIVEL")StatusProduto status){
        return ResponseEntity.ok().body(produtoService.filtraProdutosPeloStatus(status));
    }

}
