package com.example.ProjetoFinal.controller;

import com.example.ProjetoFinal.model.Cliente;
import com.example.ProjetoFinal.model.Produto;
import com.example.ProjetoFinal.repository.ProdutoRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository prrepo;

    @PostMapping("/cadastrar")
        public void CadastrarCliente(@RequestBody Produto pd){
            prrepo.save(pd);
        }


    @PostMapping("/todos")
        public List<Produto> buscarTodosProdutos(){
            return prrepo.findAll();

    }

    @PostMapping("/todos/codigo/{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable ("codigo") int codigo){
        return prrepo.findById(codigo);
    }

    @

}
