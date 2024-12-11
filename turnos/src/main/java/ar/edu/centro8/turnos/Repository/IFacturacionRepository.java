package ar.edu.centro8.turnos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.centro8.turnos.Model.Facturacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacturacionRepository extends JpaRepository<Facturacion, Long> {

   
    // Búsqueda por método de pago
    List<Facturacion> findByMetodoPago(@Param("metodoPago") String metodoPago);

    // Búsqueda por turno
    @Query(name = "Facturacion.findByTurno")
    List<Facturacion> findByTurno(@Param("idTurno") Long idTurno);

    // Búsqueda por paciente
    @Query(name = "Facturacion.findByPaciente")
    List<Facturacion> findByPaciente(@Param("idPaciente") Long idPaciente);
}

