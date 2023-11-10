package com.example.ProjetoFinal.controller;

import com.example.ProjetoFinal.model.Cliente;
import com.example.ProjetoFinal.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {

    @Autowired
    Repository clorepo;

    @PostMapping("/cadastrar")
    public void cadastrarCliente(@RequestBody Cliente clo ){
        clorepo.save(clo);
    }

    @GetMapping("/todos")
    public List<Cliente> buscarTodosClientes(){
      return clorepo.findAll();
    }

    @GetMapping("/todos/codigo/{codigo}")
    public Optional<Cliente> buscarPorCodigo(@PathVariable("codigo") int codigo){
        return clorepo.findById(codigo);
    }

@GetMapping("/todos/inicialnome/{nome}")
    public List<Cliente> buscarPorInicialNome(@PathVariable("nome") String nome){
        return clorepo.findByInicialNome(nome);
}

@GetMapping("/todos/email/{email}")
    public List<Cliente> buscarPorEmail(@PathVariable("email") String email){
        return clorepo.findByEmail(email);
}

@GetMapping("/todos/nomeemail/{nome}/{email}")
    public List<Cliente> buscarPorNomeEmail(@PathVariable("nome") String nome, @PathVariable("email") String email){
        return clorepo.findByNomeEmail(nome, email);
}

@DeleteMapping("/remover")
    public void removerCliente(@RequestBody Cliente cl){
        clorepo.delete(cl);
}

@DeleteMapping("/remover/codigo/{codigo}")
    public void removerClientePorCodigo(@PathVariable("codigo") int codigo){
        clorepo.deleteById(codigo);
}

@PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cl){
        clorepo.save(cl);
}

}
