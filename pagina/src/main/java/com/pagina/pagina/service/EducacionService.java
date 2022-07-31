
package com.pagina.pagina.service;

import com.pagina.pagina.model.Educacion;
import com.pagina.pagina.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepository edurepo;

    public List<Educacion> list() {
        return edurepo.findAll();
    }

    public Optional<Educacion> getOne(long id) {
        return edurepo.findById(id);
    }

    public Optional<Educacion> getByTituloEdu(String tituloEdu) {
        return edurepo.findByTituloEdu(tituloEdu);
    }

    public void save(Educacion edu) {
        edurepo.save(edu);
    }

    public void delete(long id) {
        edurepo.deleteById(id);
    }

    public boolean existsById(long id) {
        return edurepo.existsById(id);
    }

    public boolean existsByTituloEdu(String tituloEdu) {
        return edurepo.existsByTituloEdu(tituloEdu);
    }
}
