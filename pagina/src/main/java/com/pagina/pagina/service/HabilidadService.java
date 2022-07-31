
package com.pagina.pagina.service;

import com.pagina.pagina.model.Habilidad;
import com.pagina.pagina.repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class HabilidadService {
    
    @Autowired
    HabilidadRepository habrepo;

    public List<Habilidad> list() {
        return habrepo.findAll();
    }

    public Optional<Habilidad> getOne(long id) {
        return habrepo.findById(id);
    }

    public Optional<Habilidad> getByNombreHab(String nombre) {
        return habrepo.findByNombreHab(nombre);
    }

    public void save(Habilidad hab) {
        habrepo.save(hab);
    }

    public void delete(long id) {
        habrepo.deleteById(id);
    }

    public boolean existsById(long id) {
        return habrepo.existsById(id);
    }

    public boolean existsByNombreHab(String nombreHab) {
        return habrepo.existsByNombreHab(nombreHab);
    }
    
}
