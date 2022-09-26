/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.service;

import java.util.Optional;
import my_project.my_project.domain.Delovi;
import my_project.my_project.repository.DeloviRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static junit.framework.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author User
 */
@SpringBootTest
public class DeloviServiceTests {
    
    @Autowired
    private DeloviService deloviService;
    
    @MockBean
    private DeloviRepository deloviRepository;
    
    //@Test
    public void saveTest(){
          Delovi delovi = deloviService.save(new Delovi(1l, "Save_test_1", 1d, "Save_test_1"));
          when(deloviRepository.save(delovi)).thenReturn(delovi);
          Delovi d = deloviService.save(delovi);
          assertNotNull(d);
    }
    
    @Test
    public void deleteTest(){
        Delovi delovi = new Delovi(2l,"Delete_test_2", 2d, "Delete_test_2");
        Optional<Delovi> d = Optional.of(delovi);
        when(deloviRepository.findById(delovi.getIddelovi())).thenReturn(d);
        deloviService.deleteById(delovi.getIddelovi());
        verify(deloviRepository, times(1)).deleteById(delovi.getIddelovi());
    }
    
}
