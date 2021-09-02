package com.example.resolucaotrabalhoavaliativo1.repositorio;

import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorResponse;
import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class FornecedorRepositorioTest {

    @Autowired
     FornecedorRepositorio fornecedorRepositorio;


    @Test
    void salvar() {

        Fornecedor fornecedor = new Fornecedor(
                "7878587585",
                "Lucao",
                "Lucao@org",
                "58756293"
        );

        Fornecedor resultado = fornecedorRepositorio.salvar(fornecedor);

        Assertions.assertEquals(
                fornecedor.getId().toString(),
                resultado.getId().toString()
        );


    }

    @Test
    void procurarPorId() {


        Fornecedor fornecedor = new Fornecedor(

                "7878587585",
                "Lucao",
                "Lucao@org",
                "58756293"
        );

        fornecedorRepositorio.salvar(fornecedor);
        Fornecedor resultado = fornecedorRepositorio.procurarPorId(fornecedor.getId());

        Assertions.assertEquals(
                fornecedor.getId().toString(),
                resultado.getId().toString()
        );
    }
}