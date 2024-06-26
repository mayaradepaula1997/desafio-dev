package com.desafio.cadastro_produto.controller;


import com.desafio.cadastro_produto.domain.Produto;
import com.desafio.cadastro_produto.domain.ProdutoDTO;
import com.desafio.cadastro_produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

   @Autowired
    private ProdutoService produtoService;

   @PostMapping
    public ResponseEntity<List<ProdutoDTO>>criarProduto(@RequestBody Produto produto){
       produtoService.novoProduto(produto);
       List<ProdutoDTO>listaAtualizada = produtoService.listaOrdenadaPreco();
       return ResponseEntity.ok(listaAtualizada);

   }

   @GetMapping
    public ResponseEntity<List<ProdutoDTO>>listaOrdenadaPreco(){
       List<ProdutoDTO> lista = produtoService.listaOrdenadaPreco();
       return ResponseEntity.ok(lista);
   }





}
