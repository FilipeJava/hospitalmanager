package br.com.fiap.hospitalmanager.medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService service;
    
   @GetMapping
    public String index(Model model){
        model.addAttribute("medicos",service.findAll());
        return "medico/index";
    }


     @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id){

        service.delete(id); 

        return"redirect:/medico";

    }


    
}
