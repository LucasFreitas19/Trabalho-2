package com.example.resolucaotrabalhoavaliativo1.repositorio;

import com.example.resolucaotrabalhoavaliativo1.dominio.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class FornecedorRepositorio {

    private List<Fornecedor> fornecedores = new ArrayList<>();

    public Fornecedor salvar(Fornecedor fornecedorParaSalvar) {
        fornecedores.add(fornecedorParaSalvar);

        return fornecedorParaSalvar;
    }

    public Fornecedor procurarPorId(UUID id) {
        for (Fornecedor inst : fornecedores) {
            if (inst.getId().equals(id)) {
                return inst;
            }
        }

        return null;
    }

}
