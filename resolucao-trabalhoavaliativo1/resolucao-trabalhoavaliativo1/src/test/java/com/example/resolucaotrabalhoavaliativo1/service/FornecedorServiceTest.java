package com.example.resolucaotrabalhoavaliativo1.service;

import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorResponse;
import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import com.example.resolucaotrabalhoavaliativo1.repositorio.FornecedorRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FornecedorServiceTest {
    @Mock
    private FornecedorRepositorio fornecedorRepositorio;

    @InjectMocks
    private FornecedorService fornecedorService;

    @Test
    void salvar() {
        //arranje
        FornecedorRequest fornecedorRequestTest = new FornecedorRequest("852",
                "é isso",
                "lucao@gmail",
                "5452515");
        Fornecedor fornecedorTest = fornecedorRequestTest.converterParaDominio();
        FornecedorResponse fornecedorResponseTest = new FornecedorResponse(
                fornecedorTest.getId()
        );


        Mockito
                .when(fornecedorRepositorio.salvar(Mockito.any()))
                .thenReturn(fornecedorTest);

        //act
        FornecedorResponse resultado = fornecedorService.salvar(fornecedorRequestTest);

        //assert
        Assertions.assertEquals(fornecedorResponseTest.getId().toString(), resultado.getId().toString());

    }
}