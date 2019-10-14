/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.curso.boot.demomvc.web.conversor;

import com.example.curso.boot.demomvc.domain.Departamento;
import com.example.curso.boot.demomvc.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author rhuan.silva
 */
@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{
    @Autowired
    private DepartamentoService service;
    
    @Override
    public Departamento convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        
        return service.buscarPorId(id);
    }
    
}
