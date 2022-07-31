
package com.pagina.pagina.service;

import com.pagina.pagina.model.Proyecto;
import com.pagina.pagina.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ProyectoService  {
    
  @Autowired
    ProyectoRepository proyerepo;

    public List<Proyecto> list() {
        return proyerepo.findAll();
    }

    public Optional<Proyecto> getOne(long id) {
        return proyerepo.findById(id);
    }

    public Optional<Proyecto> getByNombreProye(String nombreProye) {
        return proyerepo.findByNombreProye(nombreProye);
    }

    public void save(Proyecto proye) {
        proyerepo.save(proye);
    }

    public void delete(long id) {
        proyerepo.deleteById(id);
    }

    public boolean existsById(long id) {
        return proyerepo.existsById(id);
    }

    public boolean existsByNombreProye(String nombreProye) {
        return proyerepo.existsByNombreProye(nombreProye);
    } 
}
