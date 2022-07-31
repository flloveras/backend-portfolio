
package com.pagina.pagina.service;

import com.pagina.pagina.model.Experiencia;
import com.pagina.pagina.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ExperienciaService {
    
    
    @Autowired
    ExperienciaRepository exprepo;

    public List<Experiencia> list() {
        return exprepo.findAll();
    }

    public Optional<Experiencia> getOne(long id) {
        return exprepo.findById(id);
    }

    public Optional<Experiencia> getByPuestoExp(String titulo) {
        return exprepo.findByPuestoExp(titulo);
    }

    public void save(Experiencia exp) {
        exprepo.save(exp);
    }

    public void delete(long id) {
        exprepo.deleteById(id);
    }

    public boolean existsById(long id) {
        return exprepo.existsById(id);
    }

    public boolean existsByPuestoExp(String tituloExp) {
        return exprepo.existsByPuestoExp(tituloExp);
    }
    
}

