
package com.pagina.pagina.repository;

import com.pagina.pagina.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository  extends JpaRepository<Experiencia, Long>{
    public Optional<Experiencia> findByPuestoExp(String titulo);
    public boolean existsByPuestoExp(String titulo);
}
