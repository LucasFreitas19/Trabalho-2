package com.example.resolucaotrabalhoavaliativo1.controller.recursos;

import com.example.resolucaotrabalhoavaliativo1.dominio.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoRequest {

    @JsonProperty("nome_produto")
    private String nomeProduto;

    @JsonProperty("preco_custo")
    private String precoCusto;

    @JsonProperty("valor_venda")
    private String valorVenda;

    @JsonProperty("estoque")
    private String estoque;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nomeProduto, String precoCusto, String valorVenda, String estoque) {
        this.nomeProduto = nomeProduto;
        this.precoCusto = precoCusto;
        this.valorVenda = valorVenda;
        this.estoque = estoque;
    }

    public Produto converterParaDominio() {
        return new Produto(
                nomeProduto,
                Double.valueOf(precoCusto),
                Double.valueOf(valorVenda),
                Integer.valueOf(estoque)
        );
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(String precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }
}
