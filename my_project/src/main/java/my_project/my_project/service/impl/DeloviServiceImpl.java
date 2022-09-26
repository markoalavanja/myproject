/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.service.impl;

import java.util.List;
import java.util.Optional;
import my_project.my_project.domain.Delovi;
import my_project.my_project.repository.DeloviRepository;
import my_project.my_project.service.DeloviService;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DeloviServiceImpl implements DeloviService{
    
    private DeloviRepository deloviRepository;

    public DeloviServiceImpl(DeloviRepository deloviRepository) {
        this.deloviRepository = deloviRepository;
    }
    

    @Override
    public List<Delovi> findAll() {
        return deloviRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        deloviRepository.deleteById(id);
    }

    @Override
    public Delovi save(Delovi delovi) {
        return deloviRepository.save(delovi);
    }

    @Override
    public Optional<Delovi> findById(Long id) {
        return deloviRepository.findById(id);
    }
}
