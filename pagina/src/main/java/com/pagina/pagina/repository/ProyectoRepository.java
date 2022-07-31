
package com.pagina.pagina.repository;

import com.pagina.pagina.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
     public Optional<Proyecto> findByNombreProye(String titulo);
    public boolean existsByNombreProye(String titulo);
}
