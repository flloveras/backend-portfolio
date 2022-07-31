
package com.pagina.pagina.service;

import com.pagina.pagina.model.Persona;
import com.pagina.pagina.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PersonaService {
    
    
    @Autowired 
    PersonaRepository persorepo;
    
    public List<Persona> list() {
        return persorepo.findAll();
    }

    public void save(Persona persona) {
        persorepo.save(persona);
    }

    public void delete(Long id) {
        persorepo.deleteById(id);
    }

    public Persona find(Long id) {
        return persorepo.findById(id).orElse(null);
    }

    public Optional<Persona> getOne(long id) {
        return persorepo.findById(id);
    }
    
    public boolean existsById(long id) {
        return persorepo.existsById(id);
    }
    
}