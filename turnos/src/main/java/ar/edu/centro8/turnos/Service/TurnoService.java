package ar.edu.centro8.turnos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.centro8.turnos.Model.Nutricionista;
import ar.edu.centro8.turnos.Model.Paciente;
import ar.edu.centro8.turnos.Model.Turno;
import ar.edu.centro8.turnos.Repository.INutricionistaRepository;
import ar.edu.centro8.turnos.Repository.IPacienteRepository;
import ar.edu.centro8.turnos.Repository.ITurnoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class TurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private INutricionistaRepository nutricionistaRepository;

    public Turno crearTurno(Long nutricionistaId, LocalDate fecha, LocalTime hora) {
        // Buscar el nutricionista por ID
        Nutricionista nutricionista = nutricionistaRepository.findById(nutricionistaId)
                .orElseThrow(() -> new IllegalArgumentException("Nutricionista con ID " + nutricionistaId + " no encontrado"));

        // Crear un objeto Turno
        Turno turno = new Turno();
        turno.setNutricionista(nutricionista); // Establecer la relación
        turno.setFecha(fecha);
        turno.setHora(hora);
        turno.setEstado("Disponible"); // Estado inicial

        // Guardar en la base de datos
        return turnoRepository.save(turno);
    }

    public Turno reservarTurno(Long turnoId, Long pacienteId) {
    Turno turno = turnoRepository.findById(turnoId)
            .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    
    if (!"Disponible".equals(turno.getEstado())) {
        throw new RuntimeException("El turno no está disponible para reservar");
    }

    Paciente paciente = pacienteRepository.findById(pacienteId)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    
    turno.setEstado("Reservado");
    turno.setPaciente(paciente);

    return turnoRepository.save(turno);
}

public Turno cancelarReserva(Long turnoId) {
    Turno turno = turnoRepository.findById(turnoId)
            .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

    if (!"Reservado".equals(turno.getEstado())) {
        throw new RuntimeException("El turno no está reservado, no se puede cancelar");
    }

    turno.setEstado("Disponible");
    turno.setPaciente(null);

    return turnoRepository.save(turno);
}

public List<Turno> obtenerTurnosDisponiblesPorNutricionista(Long nutricionistaId) {
    // Buscar todos los turnos del nutricionista cuyo estado sea "Disponible"
    return turnoRepository.findByNutricionistaIdAndEstado(nutricionistaId, "Disponible");
}

}

