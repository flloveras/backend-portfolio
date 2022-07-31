
package com.pagina.pagina.controller;

import com.pagina.pagina.dto.DtoExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pagina.pagina.model.Experiencia;
import com.pagina.pagina.security.Controller.Mensaje;
import com.pagina.pagina.service.ExperienciaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ExperienciaController {
	
	@Autowired
    private ExperienciaService expservice;

    @GetMapping("/experiencia/vertodos")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = expservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/experiencia/ver/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") long id) {
        if (!expservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia exp = expservice.getOne(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }
    
    @DeleteMapping("/experiencia/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!expservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        expservice.delete(id);
        return new ResponseEntity(new Mensaje("se eliminó correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/experiencia/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getPuestoExp())) {
            return new ResponseEntity(new Mensaje("El nombre del puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (expservice.existsByPuestoExp(dtoexp.getPuestoExp())) {
            return new ResponseEntity(new Mensaje("Ese puesto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia exp = new Experiencia(dtoexp.getPuestoExp(), dtoexp.getDescripcionExp(), dtoexp.getEmpresaExp(),
                                    dtoexp.getAniodesdeExp(), dtoexp.getAniohastaExp());
        expservice.save(exp);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PutMapping("/experiencia/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody DtoExperiencia dtoexp) {
        
        if (!expservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (expservice.existsByPuestoExp(dtoexp.getPuestoExp()) && expservice.getByPuestoExp(dtoexp.getPuestoExp()).get().getIdExp()!= id) {
            return new ResponseEntity(new Mensaje("Ese puesto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoexp.getPuestoExp())) {
            return new ResponseEntity(new Mensaje("El nombre del puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia exp = expservice.getOne(id).get();
        exp.setPuestoExp(dtoexp.getPuestoExp());
        exp.setDescripcionExp(dtoexp.getDescripcionExp());
        exp.setEmpresaExp(dtoexp.getEmpresaExp());
        exp.setAniodesdeExp(dtoexp.getAniodesdeExp());
        exp.setAniohastaExp(dtoexp.getAniohastaExp());

        expservice.save(exp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}