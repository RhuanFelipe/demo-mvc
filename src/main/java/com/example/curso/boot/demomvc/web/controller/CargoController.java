package com.example.curso.boot.demomvc.web.controller;

import com.example.curso.boot.demomvc.domain.Cargo;
import com.example.curso.boot.demomvc.domain.Departamento;
import com.example.curso.boot.demomvc.service.CargoService;
import com.example.curso.boot.demomvc.service.DepartamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;
    
    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo){
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }
    
    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
        return "redirect:/cargos/cadastrar";
    }
    
    @ModelAttribute("departamentos")
    public List<Departamento> listarDepartamentos(){
        return departamentoService.buscarTodos();
    }
}
