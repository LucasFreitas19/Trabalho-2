package com.example.resolucaotrabalhoavaliativo1.service;

import com.example.resolucaotrabalhoavaliativo1.controller.recursos.AdicaoFornecedorRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorResponse;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.ProdutoRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.ProdutoResponse;
import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import com.example.resolucaotrabalhoavaliativo1.dominio.Produto;
import com.example.resolucaotrabalhoavaliativo1.exception.FornecedorNaoEncontradoException;
import com.example.resolucaotrabalhoavaliativo1.exception.ProdutoNaoEncontradoException;
import com.example.resolucaotrabalhoavaliativo1.repositorio.FornecedorRepositorio;
import com.example.resolucaotrabalhoavaliativo1.repositorio.ProdutoRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private FornecedorRepositorio fornecedorRepositorio;

    public ProdutoResponse salvar(ProdutoRequest produtoRequest) {
        Produto produtoConvertido = produtoRequest.converterParaDominio();

        Produto produtoSalvo = produtoRepositorio.salvar(produtoConvertido);

        ProdutoResponse produtoResponse = new ProdutoResponse(produtoSalvo.getId());

        return produtoResponse;
    }

    public List<ProdutoResponse> procurarTodos(String nome) {
        List<ProdutoResponse> resultadoProdutoResponse = new ArrayList<>();
        List<Produto> resultadoProduto;

        if (nome == null) {
            resultadoProduto = produtoRepositorio.retornarTodos();
        } else {
            resultadoProduto = produtoRepositorio.retornarTodos(nome);
        }

        for (Produto inst : resultadoProduto) {
            ProdutoResponse produtoResponseConvertido = new ProdutoResponse(inst);
            resultadoProdutoResponse.add(produtoResponseConvertido);
        }

        return resultadoProdutoResponse;
    }

    public ProdutoResponse recuperarEstoque(String id) {
        UUID uuid = UUID.fromString(id);

        Produto produtoEncontrado = produtoRepositorio.procurarPorId(uuid);

        if (produtoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }

        ProdutoResponse produtoResponse = new ProdutoResponse(produtoEncontrado.getEstoque().toString());

        return produtoResponse;
    }

    public ProdutoResponse recuperarPorId(String id) {
        UUID uuid = UUID.fromString(id);

        Produto produtoEncontrado = produtoRepositorio.procurarPorId(uuid);

        if (produtoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }

        ProdutoResponse produtoResponse = new ProdutoResponse(produtoEncontrado);

        return produtoResponse;
    }

    public void adicionarFornecedor(String idProduto, AdicaoFornecedorRequest request) {
        //procurar produto
        UUID uuidProduto = UUID.fromString(idProduto);
        Produto produtoEncontrado = produtoRepositorio.procurarPorId(uuidProduto);

        if (produtoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }

        //procurar fornecedor
        UUID uuidFornecedor = UUID.fromString(request.getFornecedor().getId());
        Fornecedor fornecedorEncontrado = fornecedorRepositorio.procurarPorId(uuidFornecedor);

        if (fornecedorEncontrado == null) {
            throw new FornecedorNaoEncontradoException();
        }

        //adicionar fornecedor no produto
        produtoEncontrado.adicionarFornecedor(fornecedorEncontrado);

        //salvar produto atualizado com o fornecedor
        produtoRepositorio.salvar(produtoEncontrado);
    }

    public List<FornecedorResponse> retornarFornecedor(String idProduto) {
        UUID uuidProduto = UUID.fromString(idProduto);
        Produto produtoEncontrado = produtoRepositorio.procurarPorId(uuidProduto);

        if (produtoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }

        List<FornecedorResponse> fornecedoresResponseResultado = new ArrayList<>();

        for (Fornecedor fornecedorInst : produtoEncontrado.getFornecedores()) {
            FornecedorResponse fornecedorResponse = new FornecedorResponse(fornecedorInst);
            fornecedoresResponseResultado.add(fornecedorResponse);
        }

        return fornecedoresResponseResultado;
    }
}
