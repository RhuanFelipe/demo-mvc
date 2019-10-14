/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.curso.boot.demomvc.service;

import com.example.curso.boot.demomvc.dao.FuncionarioDao;
import com.example.curso.boot.demomvc.domain.Funcionario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rhuan.silva
 */
@Transactional(readOnly = true)
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao dao;
    
    @Override
    @Transactional(readOnly = false)
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }

}
