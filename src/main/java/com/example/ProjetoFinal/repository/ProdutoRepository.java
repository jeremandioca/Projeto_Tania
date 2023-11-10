package com.example.ProjetoFinal.repository;

import com.example.ProjetoFinal.model.Cliente;
import com.example.ProjetoFinal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query ("select a from Produto a where a.marca like ?1")
    List<Produto> findByMarca(String marca);

    @Query("select a from Produto a where a.descricao like ?1%")
    List<Produto> findByInicialDescricao(String descricao);

    @Query("select a from Produto a where a.preco < ?1")
    List<Produto> findByMaisBarato(double preco);

    @Query("select a from Produto a where a.marca like %?1% and a.preco < ?2")
    List<Produto> findByMarcaPreco (String marca, double preco);
}
