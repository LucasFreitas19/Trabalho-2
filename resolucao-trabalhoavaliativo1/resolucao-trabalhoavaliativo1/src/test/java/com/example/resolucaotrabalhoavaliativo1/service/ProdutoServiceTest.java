package com.example.resolucaotrabalhoavaliativo1.service;

import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorResponse;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.ProdutoRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.ProdutoResponse;
import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import com.example.resolucaotrabalhoavaliativo1.dominio.Produto;
import com.example.resolucaotrabalhoavaliativo1.repositorio.ProdutoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepositorio produtoRepositorio;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    void salvar() {
        ProdutoRequest produtoRequestTest = new ProdutoRequest(
                "Laptop",
                "54",
                "82",
                "5"
        );
        Produto produtoTest = produtoRequestTest.converterParaDominio();
        ProdutoResponse produtoResponseTest = new ProdutoResponse(
                produtoTest.getId()
        );

        Mockito.when(produtoRepositorio.salvar(Mockito.any()))
                .thenReturn(produtoTest);

        ProdutoResponse resultado = produtoService.salvar(produtoRequestTest);

        Assertions.assertEquals(produtoResponseTest.getId().toString(),resultado.getId().toString() );


    };

    @Test
    void procurarTodos() {
        List<Produto> resultadoProduto = new ArrayList<>();

        Produto produtoTest = new Produto(
                "Pelo",
                1.9,
                2.0,
                3
        );
        resultadoProduto.add(produtoTest);
        ProdutoResponse produtoResponseTest = new ProdutoResponse();

        resultadoProduto.add(produtoTest);

        Mockito
                .when(produtoRepositorio.retornarTodos())
                .thenReturn(resultadoProduto);

        List<ProdutoResponse> resultado = produtoService.procurarTodos(null);

        Assertions.assertEquals(resultadoProduto.get(0).getId().toString(),
                resultado.get(0).getId().toString());

    }

    @Test
    void procurarTodosPorNome() {
        List<Produto> resultadoProduto = new ArrayList<>();

        Produto produtoTest = new Produto(
                "Pelo",
                1.9,
                2.0,
                3
        );
        resultadoProduto.add(produtoTest);
        ProdutoResponse produtoResponseTest = new ProdutoResponse();

        resultadoProduto.add(produtoTest);

        Mockito
                .when(produtoRepositorio.retornarTodos("Pelo"))
                .thenReturn(resultadoProduto);

        List<ProdutoResponse> resultado = produtoService.procurarTodos("Pelo");

        Assertions.assertEquals(resultadoProduto.get(0).getNomeProduto(),
                resultado.get(0).getNomeProduto());

    }

    @Test
    void procurarTodosFail() {
        List<Produto> resultadoProduto = new ArrayList<>();

        Produto produtoTest = new Produto(
                "Pelo",
                1.9,
                2.0,
                3
        );

        ProdutoResponse produtoResponseTest = new ProdutoResponse();



        Mockito
                .when(produtoRepositorio.retornarTodos())
                .thenReturn(resultadoProduto);

        List<ProdutoResponse> resultado = produtoService.procurarTodos(null);

        Assertions.assertTrue(resultado.isEmpty());

    }

    @Test
    void recuperarEstoque() {

        Produto produtoTest = new Produto(
                "Pelo",
                1.9,
                2.0,
                3
        );

        ProdutoResponse produtoResponseTest = new ProdutoResponse();

        Mockito
                .when(produtoRepositorio.procurarPorId(Mockito.any()))
                .thenReturn(produtoTest);

        ProdutoResponse resultado = produtoService.recuperarEstoque(produtoTest.getId().toString());

        Assertions.assertEquals(
                produtoTest.getEstoque().toString(),
                resultado.getEstoque().toString());
    }

    @Test
    void recuperarPorId() {

        Produto produtoTest = new Produto(
                "Pelo",
                1.9,
                2.0,
                3
        );

        ProdutoResponse produtoResponseTest = new ProdutoResponse();

        Mockito
                .when(produtoRepositorio.procurarPorId(Mockito.any()))
                .thenReturn(produtoTest);

        ProdutoResponse resultado = produtoService.recuperarPorId(produtoTest.getId().toString());

        Assertions.assertEquals(
                produtoTest.getId().toString(),
                resultado.getId().toString()
        );
    }

    @Test
    void adicionarFornecedor() {


    }

    @Test
    void retornarFornecedor() {

        Produto produtoTest = new Produto(
                "Pelo",
                1.9,
                2.0,
                3
        );

        Fornecedor fornecedor = new Fornecedor
                ("852",
                "é isso",
                "lucao@gmail",
                "5452515");

        produtoTest.adicionarFornecedor(fornecedor);

        Mockito
                .when(produtoRepositorio.procurarPorId(Mockito.any()))
                .thenReturn(produtoTest);

        List<FornecedorResponse> resultado = produtoService.retornarFornecedor(produtoTest.getId().toString());

        Assertions.assertEquals(
                produtoTest.getFornecedores().get(0).getId().toString(),
                resultado.get(0).getId()
        );
    }
}