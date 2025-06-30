/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Repositories;

/**
 * Classe para 
 * @author Lucas Gonçalves
 * @since Classe criada em 30 de jun. de 2025
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Models.Pessoa;

@Repository

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
