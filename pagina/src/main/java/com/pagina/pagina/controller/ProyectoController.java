
package com.pagina.pagina.controller;

import com.pagina.pagina.dto.DtoProyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pagina.pagina.model.Proyecto;
import com.pagina.pagina.security.Controller.Mensaje;
import com.pagina.pagina.service.ProyectoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
    @Autowired
    private ProyectoService proyeservice;

    @GetMapping("/proyecto/vertodos")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyeservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/proyecto/ver/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") long id) {
        if (!proyeservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto edu = proyeservice.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
    @DeleteMapping("/proyecto/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!proyeservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyeservice.delete(id);
        return new ResponseEntity(new Mensaje("se eliminó correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/proyecto/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproye) {
        if (StringUtils.isBlank(dtoproye.getNombreProye())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (proyeservice.existsByNombreProye(dtoproye.getNombreProye())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proye = new Proyecto(dtoproye.getNombreProye(), dtoproye.getUrlProye(), dtoproye.getDescripcionProye(), dtoproye.getAnioProye());
                                    
        proyeservice.save(proye);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PutMapping("/proyecto/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody DtoProyecto dtoproye) {
        
        if (!proyeservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (proyeservice.existsByNombreProye(dtoproye.getNombreProye()) && proyeservice.getByNombreProye(dtoproye.getNombreProye()).get().getIdProye()!= id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoproye.getNombreProye())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proye = proyeservice.getOne(id).get();
        proye.setNombreProye(dtoproye.getNombreProye());
        proye.setUrlProye(dtoproye.getUrlProye());
        proye.setDescripcionProye(dtoproye.getDescripcionProye());
        proye.setAnioProye(dtoproye.getAnioProye());

        proyeservice.save(proye);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }
}
