package br.com.fiap.hospitalmanager.medico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    
@Autowired
MedicoRepository repository;


public List<Medico> findAll(){
    return repository.findAll();
}


public void delete (Long id){
    repository.deleteById(id);
}




}
