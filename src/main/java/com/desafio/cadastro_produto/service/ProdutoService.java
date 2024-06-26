package com.desafio.cadastro_produto.service;


import com.desafio.cadastro_produto.domain.Produto;
import com.desafio.cadastro_produto.domain.ProdutoDTO;
import com.desafio.cadastro_produto.repository.ProdutoRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {


@Autowired
private ProdutoRepositoty produtoRepositoty;


    public Produto novoProduto (Produto produto){
        return produtoRepositoty.save(produto);


    }


   public List<ProdutoDTO> listaOrdenadaPreco (){
       List<Produto> produtos = produtoRepositoty.findAll();
       List<ProdutoDTO> produtoDTO = produtos.stream()   //Converte a lista de produtos em um stream
               .sorted(Comparator.comparingDouble(Produto::getPreco)) //Ordena o stream de produtos pelo preço.
               .map(produto -> new ProdutoDTO(produto.getId(),produto.getNome(), produto.getPreco())) //tranforma cada obj Produto em um obj ProdutoDTO
               .collect(Collectors.toList()); //Transforma a stream em uma lista novamente

       return produtoDTO;
   }



}
