package com.example.ProjetoFinal.controller;

import com.example.ProjetoFinal.model.Cliente;
import com.example.ProjetoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository clrepo;

    @PostMapping("/cadastrar")
    public void cadastrarCliente(@RequestBody Cliente cl ){
        clrepo.save(cl);
    }

    @GetMapping("/todos")
    public List<Cliente> buscarTodosClientes(){
      return clrepo.findAll();
    }

    @GetMapping("/todos/codigo/{codigo}")
    public Optional<Cliente> buscarPorCodigo(@PathVariable("codigo") int codigo){
        return clrepo.findById(codigo);
    }

@GetMapping("/todos/inicialnome/{nome}")
    public List<Cliente> buscarPorInicialNome(@PathVariable("nome") String nome){
        return clrepo.findByInicialNome(nome);
}

@GetMapping("/todos/email/{email}")
    public List<Cliente> buscarPorEmail(@PathVariable("email") String email){
        return clrepo.findByEmail(email);
}

@GetMapping("/todos/nomeemail/{nome}/{email}")
    public List<Cliente> buscarPorNomeEmail(@PathVariable("nome") String nome, @PathVariable("email") String email){
        return clrepo.findByNomeEmail(nome, email);
}

@DeleteMapping("/remover")
    public void removerCliente(@RequestBody Cliente cl){
        clrepo.delete(cl);
}

@DeleteMapping("/remover/codigo/{codigo}")
    public void removerClientePorCodigo(@PathVariable("codigo") int codigo){
        clrepo.deleteById(codigo);
}

@PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cl){
        clrepo.save(cl);
}

}
