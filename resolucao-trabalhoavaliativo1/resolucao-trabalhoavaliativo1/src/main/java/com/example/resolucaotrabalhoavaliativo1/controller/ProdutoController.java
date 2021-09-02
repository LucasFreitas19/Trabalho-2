package com.example.resolucaotrabalhoavaliativo1.controller;

import com.example.resolucaotrabalhoavaliativo1.controller.recursos.AdicaoFornecedorRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorResponse;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.ProdutoRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.ProdutoResponse;
import com.example.resolucaotrabalhoavaliativo1.exception.FornecedorNaoEncontradoException;
import com.example.resolucaotrabalhoavaliativo1.exception.ProdutoNaoEncontradoException;
import com.example.resolucaotrabalhoavaliativo1.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvar(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse resposta = produtoService.salvar(produtoRequest);

        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> procurarTodos(@RequestParam(required = false) String nome) {
        List<ProdutoResponse> resultado = produtoService.procurarTodos(nome);

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("{id}/estoque")
    public ResponseEntity<ProdutoResponse> recuperarEstoque(@PathVariable String id) {
        ProdutoResponse resultado;

        try {
            resultado = produtoService.recuperarEstoque(id);
        } catch (ProdutoNaoEncontradoException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponse> recuperarPorId(@PathVariable String id) {
        ProdutoResponse resultado;

        try {
            resultado = produtoService.recuperarPorId(id);
        } catch (ProdutoNaoEncontradoException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PutMapping("{idProduto}/fornecedor")
    public ResponseEntity<Void> adicionarFornecedor(
            @PathVariable String idProduto,
            @RequestBody AdicaoFornecedorRequest request
    ) {
        try {
            produtoService.adicionarFornecedor(idProduto, request);
        } catch (ProdutoNaoEncontradoException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (FornecedorNaoEncontradoException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{idProduto}/fornecedor")
    public ResponseEntity<List<FornecedorResponse>> retornarFornecedor(@PathVariable String idProduto) {
        List<FornecedorResponse> fornecedorResponse;

        try {
            fornecedorResponse = produtoService.retornarFornecedor(idProduto);
        } catch (ProdutoNaoEncontradoException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(fornecedorResponse, HttpStatus.OK);
    }
}
