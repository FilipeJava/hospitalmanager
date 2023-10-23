package br.com.fiap.hospitalmanager.paciente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping
    public String index(Model model,@AuthenticationPrincipal OAuth2User user){
       model.addAttribute("avatar_url",user.getAttribute("avatar_url"));
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
    public String form(Paciente paciente){
        return "paciente/form";
    }


    @PostMapping()
    public String save ( @Valid Paciente paciente, BindingResult result, RedirectAttributes redirect){

         if (result.hasErrors()) return "/paciente/form";

        redirect.addFlashAttribute("success", "Paciente cadastrado com Sucesso"); 
        service.save(paciente);

       return"redirect:/paciente";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Paciente> paciente = service.findById(id);

        // Verifique se o paciente foi encontrado antes de adicionar ao modelo
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
        } else {
            // Redirecione para uma página de erro ou lide com a situação de paciente não encontrado
            model.addAttribute("error", "Paciente não encontrado");
            return "redirect:/paciente";            
        }

        return "paciente/update-form";
    }

      @PostMapping("/update/{id}")
    public String updatePaciente(@PathVariable("id") Long id, @Valid Paciente paciente,
                                BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "/paciente/update-form";
        }

        // Define o ID do paciente para garantir que você está atualizando o paciente correto
        paciente.setId(id);
        service.save(paciente);

        redirect.addFlashAttribute("success", "Paciente atualizado com sucesso");
        return "redirect:/paciente";
    }


}
