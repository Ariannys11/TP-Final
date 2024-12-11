package ar.edu.centro8.turnos.Controllers;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.edu.centro8.turnos.Model.Turno;
import ar.edu.centro8.turnos.Model.TurnoDTO;
import ar.edu.centro8.turnos.Service.TurnoService;



@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping("/crear")
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        Turno nuevoTurno = turnoService.crearTurno(
            turnoDTO.getNutricionistaId(),
            turnoDTO.getFecha(),
            turnoDTO.getHora()
        );
        return ResponseEntity.ok(nuevoTurno);
    }

    @PutMapping("/{turnoId}/reservar")
       public ResponseEntity<Turno> reservarTurno(
        @PathVariable Long turnoId, 
        @RequestParam Long pacienteId) {
         Turno turnoReservado = turnoService.reservarTurno(turnoId, pacienteId);
         return ResponseEntity.ok(turnoReservado);
}

@PutMapping("/{turnoId}/cancelar")
    public ResponseEntity<Turno> cancelarReserva(@PathVariable Long turnoId) {
    Turno turnoCancelado = turnoService.cancelarReserva(turnoId);
    return ResponseEntity.ok(turnoCancelado);
}

@GetMapping("/disponibles/{nutricionistaId}")
public ResponseEntity<List<Turno>> obtenerTurnosDisponiblesPorNutricionista(@PathVariable Long nutricionistaId) {
    List<Turno> turnosDisponibles = turnoService.obtenerTurnosDisponiblesPorNutricionista(nutricionistaId);
    return ResponseEntity.ok(turnosDisponibles);
 
}
}
