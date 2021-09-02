package com.example.resolucaotrabalhoavaliativo1.dominio;

import java.util.UUID;

public class Fornecedor {

    private UUID id = UUID.randomUUID();
    private String cnpj;
    private String razaoSocial;
    private String email;
    private String telefone;

    public Fornecedor(UUID id, String cnpj, String razaoSocial, String email, String telefone) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefone = telefone;
    }

    public Fornecedor(String cnpj, String razaoSocial, String email, String telefone) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
