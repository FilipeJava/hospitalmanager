package br.com.fiap.hospitalmanager.paciente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;


    public List<Paciente> findAll(){
        return repository.findAll();
    }


    public boolean delete(Long id) {
        var paciente = repository.findById(id);
        if(paciente.isEmpty()) return false;
        repository.deleteById(id);
        return true;
    }


    
    public void save(Paciente paciente) {
        repository.save(paciente);
        
    }


    public Optional<Paciente> findById(Long id) {
        return repository.findById(id);
    }



    

}
