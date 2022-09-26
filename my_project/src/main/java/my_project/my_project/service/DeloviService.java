/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.service;

import java.util.List;
import java.util.Optional;
import my_project.my_project.domain.Delovi;

/**
 *
 * @author User
 */
public interface DeloviService {
    
    List<Delovi> findAll();
    
    void deleteById(Long id);
    
    Delovi save(Delovi delovi);
    
    Optional<Delovi> findById(Long id);
    
}
