package com.example.ProjetoFinal.repository;

import com.example.ProjetoFinal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

}
