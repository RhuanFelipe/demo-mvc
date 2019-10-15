package com.example.curso.boot.demomvc.web.controller;

import com.example.curso.boot.demomvc.domain.Cargo;
import com.example.curso.boot.demomvc.domain.Funcionario;
import com.example.curso.boot.demomvc.domain.UF;
import com.example.curso.boot.demomvc.service.CargoService;
import com.example.curso.boot.demomvc.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private CargoService cargoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr) {
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionario inserido com sucesso.");
        return "redirect:/cargos/cadastrar";
    }
    
    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }
    
    @ModelAttribute("ufs")
    public UF[] getUfs(){
        return UF.values();
    }
}
