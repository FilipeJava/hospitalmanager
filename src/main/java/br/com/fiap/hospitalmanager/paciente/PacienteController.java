package br.com.fiap.hospitalmanager.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id , RedirectAttributes redirect){

        if (service.delete(id)){
           redirect.addFlashAttribute("success", "Paciente apagado com Sucesso"); 

        } else{
            redirect.addFlashAttribute("error", "Paciente não encontrado"); 
        }
        
        return"redirect:/paciente";

    }

    @GetMapping("new")
    public String form(){
        return "paciente/form";
    }


    @PostMapping()
    public String save (Paciente paciente){
        
        service.save(paciente);

       return"redirect:/paciente";
    }


}
