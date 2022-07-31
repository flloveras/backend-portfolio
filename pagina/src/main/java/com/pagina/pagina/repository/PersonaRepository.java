
package com.pagina.pagina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pagina.pagina.model.Persona;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    public Optional<Persona> findById(long id);
    public boolean existsById(long id);
}
