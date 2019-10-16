package com.example.curso.boot.demomvc.dao;

import com.example.curso.boot.demomvc.domain.Funcionario;
import java.time.LocalDate;

import java.util.List;

public interface FuncionarioDao {
    void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);

    public List<Funcionario> findByCargoId(Long id);

    public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

    public List<Funcionario> findByDataEntrada(LocalDate entrada);

    public List<Funcionario> findByDataSaida(LocalDate saida);

}
