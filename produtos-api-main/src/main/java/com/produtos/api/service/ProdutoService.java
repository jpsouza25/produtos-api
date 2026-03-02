package com.produtos.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.produtos.api.constants.StatusProduto;
import com.produtos.api.dto.ProdutoDTO;
import com.produtos.api.model.produto;
import com.produtos.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public produto salvarProduto(produto produto){
        return produtoRepository.save(produto);
    }
    
    public ProdutoDTO buscarProdutoPeloId(Long id){
        Optional<produto> produtoOpt = produtoRepository.findById(id);

    if (produtoOpt.isPresent()) {
        return produtoOpt.get().toDTO();
    }

    return null;

    }
    
    public List<ProdutoDTO> filtrarProdutosCujoNomeComecaCom(String nome){
        List<produto> produtos = produtoRepository.findByNomeLike(nome + "%");

        return produtos.stream().map(produto::toDTO).toList();
    }


    @DeleteMapping("/{id}")
    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public produto atualizarProduto(Long id,produto dadosProduto){
        Optional<produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isPresent()) {
            produto produto = produtoOpt.get();

            produto.setNome(dadosProduto.getNome());
            produto.setDescricao(dadosProduto.getDescricao());
            produto.setPreco(dadosProduto.getPreco());
            produto.setStatus(dadosProduto.getStatus());
            produto.setCategoria(dadosProduto.getCategoria());

            return produtoRepository.save(produto);
        }

        return null;
    }

    public List<ProdutoDTO> filtraProdutosPeloStatus(StatusProduto status){
        List<produto> produtos = produtoRepository.findByStatus(status);

        return produtos.stream().map(produto::toDTO).toList();
    }

    
}
