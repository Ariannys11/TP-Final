package ar.edu.centro8.turnos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.centro8.turnos.Model.Turno;


public interface ITurnoRepository extends JpaRepository<Turno, Long> {
// Método para obtener los turnos disponibles por nutricionista
List<Turno> findByNutricionistaIdAndEstado(Long nutricionistaId, String estado);
    
}

