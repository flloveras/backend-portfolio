
package com.pagina.pagina.controller;

import com.pagina.pagina.dto.DtoEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pagina.pagina.model.Educacion;
import com.pagina.pagina.security.Controller.Mensaje;
import com.pagina.pagina.service.EducacionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class EducacionController {
	
@Autowired
    private EducacionService eduservice;

    @GetMapping("/educacion/vertodos")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = eduservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/educacion/ver/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") long id) {
        if (!eduservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion edu = eduservice.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
    @DeleteMapping("/educacion/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!eduservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        eduservice.delete(id);
        return new ResponseEntity(new Mensaje("se eliminó correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/educacion/crear")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getTituloEdu())) {
            return new ResponseEntity(new Mensaje("El nombre del titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (eduservice.existsByTituloEdu(dtoedu.getTituloEdu())) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion edu = new Educacion(dtoedu.getInstitutoEdu(), dtoedu.getTituloEdu(), dtoedu.getUrlfotoEdu(),
                                    dtoedu.getAniodesdeEdu(), dtoedu.getAniohastaEdu());
        eduservice.save(edu);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PutMapping("/educacion/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody DtoEducacion dtoedu) {
        
        if (!eduservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (eduservice.existsByTituloEdu(dtoedu.getTituloEdu()) && eduservice.getByTituloEdu(dtoedu.getTituloEdu()).get().getIdEdu()!= id) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoedu.getTituloEdu())) {
            return new ResponseEntity(new Mensaje("El nombre del titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion edu = eduservice.getOne(id).get();
        edu.setInstitutoEdu(dtoedu.getInstitutoEdu());
        edu.setTituloEdu(dtoedu.getTituloEdu());
        edu.setUrlfotoEdu(dtoedu.getUrlfotoEdu());
        edu.setAniodesdeEdu(dtoedu.getAniodesdeEdu());
        edu.setAniohastaEdu(dtoedu.getAniohastaEdu());

        eduservice.save(edu);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);

    }
}