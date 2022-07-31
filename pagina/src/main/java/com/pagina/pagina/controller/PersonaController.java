
package com.pagina.pagina.controller;

import com.pagina.pagina.dto.DtoPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pagina.pagina.model.Persona;
import com.pagina.pagina.security.Controller.Mensaje;
import com.pagina.pagina.service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
    private PersonaService persoservice;

    @GetMapping("/persona/vertodos")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = persoservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/persona/ver/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") long id) {
        if (!persoservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = persoservice.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!persoservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        persoservice.delete(id);
        return new ResponseEntity(new Mensaje("se eliminó correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoperso) {
        if (StringUtils.isBlank(dtoperso.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtoperso.getNombre(), dtoperso.getApellido(), dtoperso.getTitulo(),
                dtoperso.getInfopersonal(), dtoperso.getUrlfotoperfil());
        persoservice.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody DtoPersona dtoperso) {

        if (!persoservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = persoservice.getOne(id).get();
        persona.setNombre(dtoperso.getNombre());
        persona.setApellido(dtoperso.getApellido());
        persona.setTitulo(dtoperso.getTitulo());
        persona.setInfopersonal(dtoperso.getInfopersonal());
        persona.setUrlfotoperfil(dtoperso.getUrlfotoperfil());

        persoservice.save(persona);
        return new ResponseEntity(new Mensaje("Perfil actualizado"), HttpStatus.OK);

    }
}

