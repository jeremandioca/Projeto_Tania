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
@RequestMapping("/apipro")
public class ProdutoController {

    @Autowired
    ProdutoRepository prorepo;

    @PostMapping("/cadastrar")
        public void CadastrarProduto(@RequestBody Produto pdo){
            prorepo.save(pdo);
        }


    @GetMapping("/todos")
        public List<Produto> buscarTodosProdutos(){
            return prorepo.findAll();

    }

    @GetMapping("/todos/codigo/{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable ("codigo") int codigo){
        return prorepo.findById(codigo);
    }


    @GetMapping("/todos/marca/{marca}")
    public List<Produto> buscarPorMarca(@PathVariable ("marca") String marca){
        return prorepo.findByMarca(marca);
    }

    @GetMapping("/todos/inicialDescricao/{inicial}")
    public List<Produto> buscarPorInicial(@PathVariable ("inicial") String inicial){
        return prorepo.findByInicialDescricao(inicial);
    }

    @GetMapping("/todos/MaisBaratos/{preco}")
    public List<Produto> buscarPorMaisBaratos(@PathVariable ("preco") double preco){
    return prorepo.findByMaisBarato(preco);
    }

    @GetMapping("/todos/buscarMarcaPreco/{marca}/{preco}")
    public List<Produto> buscarPorMarcaPreco(@PathVariable ("marca") String marca, @PathVariable ("preco") double preco){
        return prorepo.findByMarcaPreco(marca, preco);
    }

    @DeleteMapping("/remover")
    public void removerProduto(@RequestBody Produto prpo){
        prorepo.delete(prpo);
    }

    @DeleteMapping("/remover/codigo/{codigo}")
    public void removerProdutoPorCodigo(@PathVariable("codigo") int codigo){
        prorepo.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody Produto prpo){
        prorepo.save(prpo);
    }

}
