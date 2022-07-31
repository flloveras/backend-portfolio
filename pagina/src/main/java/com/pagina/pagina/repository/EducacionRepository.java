
package com.pagina.pagina.repository;

import com.pagina.pagina.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository  extends JpaRepository<Educacion, Long>{
    public Optional<Educacion> findByTituloEdu(String titulo);
    public boolean existsByTituloEdu(String titulo);
}
