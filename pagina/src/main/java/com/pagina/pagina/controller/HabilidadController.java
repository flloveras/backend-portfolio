
package com.pagina.pagina.controller;

import com.pagina.pagina.dto.DtoHabilidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pagina.pagina.model.Habilidad;
import com.pagina.pagina.security.Controller.Mensaje;
import com.pagina.pagina.service.HabilidadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class HabilidadController {
	
	@Autowired
    private HabilidadService habservice;

    @GetMapping("/habilidad/vertodos")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = habservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/habilidad/ver/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") long id) {
        if (!habservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Habilidad edu = habservice.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
    @DeleteMapping("/habilidad/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!habservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        habservice.delete(id);
        return new ResponseEntity(new Mensaje("se eliminó correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/habilidad/crear")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtohab) {
        if (StringUtils.isBlank(dtohab.getNombreHab())) {
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (habservice.existsByNombreHab(dtohab.getNombreHab())) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Habilidad hab = new Habilidad(dtohab.getNombreHab(), dtohab.getNivelHab());
                                    
        habservice.save(hab);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PutMapping("/habilidad/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody DtoHabilidad dtohab) {
        
        if (!habservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (habservice.existsByNombreHab(dtohab.getNombreHab()) && habservice.getByNombreHab(dtohab.getNombreHab()).get().getIdHab()!= id) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtohab.getNombreHab())) {
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidad hab = habservice.getOne(id).get();
        hab.setNombreHab(dtohab.getNombreHab());
        hab.setNivelHab(dtohab.getNivelHab());

        habservice.save(hab);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);

    }
}
