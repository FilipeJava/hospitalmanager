package br.com.fiap.hospitalmanager.paciente;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Size(min = 3)
    String nome;
 
    @NotBlank
    @Size(min = 11)
    String cpf;

    @Email
    String email;

    @NotBlank
    String telefone;

    @NotBlank
    String endereco;

    
    @Column(name = "DATANASCIMENTO")
    @NotNull
    LocalDate dataNascimento;

    
}
