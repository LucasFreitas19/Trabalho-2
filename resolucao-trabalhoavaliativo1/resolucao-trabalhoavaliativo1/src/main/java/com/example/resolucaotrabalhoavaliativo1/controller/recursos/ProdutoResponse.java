package com.example.resolucaotrabalhoavaliativo1.controller.recursos;

import com.example.resolucaotrabalhoavaliativo1.dominio.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("nome_produto")
    private String nomeProduto;

    @JsonProperty("preco_custo")
    private String precoCusto;

    @JsonProperty("valor_venda")
    private String valorVenda;

    @JsonProperty("estoque")
    private String estoque;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Produto produtoSalvo) {
        this.id = produtoSalvo.getId().toString();
        this.nomeProduto = produtoSalvo.getNomeProduto();
        this.precoCusto = produtoSalvo.getPrecoCusto().toString();
        this.valorVenda = produtoSalvo.getValorVenda().toString();
        this.estoque = produtoSalvo.getEstoque().toString();
    }

    public ProdutoResponse(UUID id) {
        this.id = id.toString();
    }

    public ProdutoResponse(String estoque) {
        this.estoque = estoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
