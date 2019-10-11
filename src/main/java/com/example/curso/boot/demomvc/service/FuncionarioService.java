/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.curso.boot.demomvc.service;

import com.example.curso.boot.demomvc.domain.Funcionario;
import java.util.List;

/**
 *
 * @author rhuan.silva
 */
public interface FuncionarioService {
    
    void salvar(Funcionario funcionario);

    void editar(Funcionario funcionario);

    void excluir(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();
}
