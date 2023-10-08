package br.com.fiap.hospitalmanager.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping
    public String index(Model model){
        model.addAttribute("pacientes",service.findAll());
        return "paciente/index";
    }

}
