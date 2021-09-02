package com.example.resolucaotrabalhoavaliativo1.controller.recursos;

import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FornecedorRequest {

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("razao_social")
    private String razaoSocial;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone")
    private String telefone;

    public FornecedorRequest(String cnpj, String razaoSocial, String email, String telefone) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefone = telefone;
    }

    public FornecedorRequest() {
    }

    public Fornecedor converterParaDominio() {
        return new Fornecedor(
                cnpj, razaoSocial, email, telefone
        );
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
