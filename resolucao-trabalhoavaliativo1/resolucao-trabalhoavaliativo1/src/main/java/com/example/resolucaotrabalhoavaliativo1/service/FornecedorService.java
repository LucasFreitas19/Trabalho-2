package com.example.resolucaotrabalhoavaliativo1.service;

import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorResponse;
import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import com.example.resolucaotrabalhoavaliativo1.repositorio.FornecedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepositorio fornecedorRepositorio;

    public FornecedorResponse salvar(FornecedorRequest fornecedorRequest) {
        Fornecedor fornecedorConvertido = fornecedorRequest.converterParaDominio();

        Fornecedor fornecedorSalvo = fornecedorRepositorio.salvar(fornecedorConvertido);

        FornecedorResponse fornecedorResponse = new FornecedorResponse(fornecedorSalvo.getId());

        return fornecedorResponse;
    }

}
