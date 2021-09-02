package com.example.resolucaotrabalhoavaliativo1.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Produto {

    private UUID id = UUID.randomUUID();
    private String nomeProduto;
    private Double precoCusto;
    private Double valorVenda;
    private Integer estoque;
    private List<Fornecedor> fornecedores = new ArrayList<>();

    public Produto(String nomeProduto, Double precoCusto, Double valorVenda, Integer estoque) {
        this.nomeProduto = nomeProduto;
        this.precoCusto = precoCusto;
        this.valorVenda = valorVenda;
        this.estoque = estoque;
    }

    public void adicionarFornecedor(Fornecedor fornecedorParaAdicionar) {
        fornecedores.add(fornecedorParaAdicionar);
    }

    public UUID getId() {
        return id;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public Integer getEstoque() {
        return estoque;
    }
}
