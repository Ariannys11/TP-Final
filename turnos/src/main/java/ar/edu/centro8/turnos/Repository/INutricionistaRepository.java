package ar.edu.centro8.turnos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.centro8.turnos.Model.Nutricionista;

import java.util.List;
@Repository
public interface INutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    // Método personalizado para buscar por especialidad
    List<Nutricionista> findByEspecialidad(String especialidad);

     Nutricionista findByMatricula(String matricula); 
}

