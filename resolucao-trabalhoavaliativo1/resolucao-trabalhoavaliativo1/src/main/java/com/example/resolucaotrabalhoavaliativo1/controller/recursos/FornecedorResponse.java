package com.example.resolucaotrabalhoavaliativo1.controller.recursos;

import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FornecedorResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("razao_social")
    private String razaoSocial;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone")
    private String telefone;

    public FornecedorResponse(UUID id) {
        this.id = id.toString();
    }

    public FornecedorResponse(Fornecedor fornecedorInst) {
        this.id = fornecedorInst.getId().toString();
        this.cnpj = fornecedorInst.getCnpj();
        this.razaoSocial = fornecedorInst.getRazaoSocial();
        this.email = fornecedorInst.getEmail();
        this.telefone = fornecedorInst.getTelefone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
