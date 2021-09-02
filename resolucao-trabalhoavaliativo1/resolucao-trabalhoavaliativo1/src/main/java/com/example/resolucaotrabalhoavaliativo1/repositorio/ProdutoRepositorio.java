package com.example.resolucaotrabalhoavaliativo1.repositorio;

import com.example.resolucaotrabalhoavaliativo1.dominio.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepositorio {

    private List<Produto> produtos = new ArrayList<>();

    public Produto salvar(Produto produtoParaSalvar) {
        produtos.add(produtoParaSalvar);

        return produtoParaSalvar;
    }

    public List<Produto> retornarTodos(String nome) {
        List<Produto> resultado = new ArrayList<>();

        for (Produto inst : produtos) {
            if (inst.getNomeProduto().contains(nome)) {
                resultado.add(inst);
            }
        }

        return resultado;
    }

    public List<Produto> retornarTodos() {
        return produtos;
    }

    public Produto procurarPorId(UUID id) {
        for (Produto inst : produtos) {
            if (inst.getId().equals(id)) {
                return inst;
            }
        }

        return null;
    }

}
