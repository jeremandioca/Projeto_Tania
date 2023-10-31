package com.example.ProjetoFinal.repository;

import ch.qos.logback.core.net.server.Client;
import com.example.ProjetoFinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

      @Query("select a from cliente a where a.nome like ?1%")
       List<Cliente> findByInicialNome(String nome);


      List<Cliente> findByEmail(String email);

      @Query("select a from cliente a where a.nome like %?1% and a.email like %?2%")
      List<Cliente> findByNomeEmail(String nome, String email);

        }
