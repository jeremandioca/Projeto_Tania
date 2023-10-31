package com.example.ProjetoFinal.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {

    @Id
    private int codigo;

    @Column
    private String nome;

    @Column
    private String email;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        codigo = Codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }
}
