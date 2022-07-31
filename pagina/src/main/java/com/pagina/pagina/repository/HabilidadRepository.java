
package com.pagina.pagina.repository;

import com.pagina.pagina.model.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long>{
     public Optional<Habilidad> findByNombreHab(String titulo);
    public boolean existsByNombreHab(String titulo);
}