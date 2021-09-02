package com.example.resolucaotrabalhoavaliativo1.controller;

import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorRequest;
import com.example.resolucaotrabalhoavaliativo1.controller.recursos.FornecedorResponse;
import com.example.resolucaotrabalhoavaliativo1.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorResponse> salvar(@RequestBody FornecedorRequest fornecedorRequest) {
        FornecedorResponse resultado = fornecedorService.salvar(fornecedorRequest);

        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

}
