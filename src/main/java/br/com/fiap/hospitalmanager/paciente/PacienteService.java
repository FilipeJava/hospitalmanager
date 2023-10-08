package br.com.fiap.hospitalmanager.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;


    public List<Paciente> findAll(){
        return repository.findAll();
    }


}
