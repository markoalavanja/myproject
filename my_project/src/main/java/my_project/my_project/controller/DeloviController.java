/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import my_project.my_project.domain.Delovi;
import my_project.my_project.service.DeloviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("delovi")
public class DeloviController {
    
    @Autowired
    private DeloviService deloviService;
    
    @GetMapping("all")
    public @ResponseBody ResponseEntity<List<Delovi>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(deloviService.findAll());
    }
    
    @GetMapping("get/{id}")
    public @ResponseBody ResponseEntity<Delovi> getById(@PathVariable Long id){
        Optional<Delovi> delovi= deloviService.findById(id);
        if(delovi.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(delovi.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("delete/{id}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable Long id){
        deloviService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Obrisan deo");
    }
    
    @PostMapping("save")
    public @ResponseBody ResponseEntity<Delovi> save(@RequestBody @Valid Delovi d){
        return ResponseEntity.status(HttpStatus.OK).body(deloviService.save(d));
    }
    
}
