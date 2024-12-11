package ar.edu.centro8.turnos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.centro8.turnos.Model.Paciente;
import ar.edu.centro8.turnos.Repository.IPacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    // Crear 
    public Paciente save(Paciente paciente) {
        // Validar que no existan dos pacientes con el mismo DNI
        Paciente existingPaciente = pacienteRepository.findByDni(paciente.getDni());
        if (existingPaciente != null && !existingPaciente.getId().equals(paciente.getId())) {
            throw new IllegalArgumentException("Ya existe un paciente con el mismo DNI");
        }
        return pacienteRepository.save(paciente);
    }

    // Obtener todos los pacientes
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    // Buscar paciente por ID
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    // Buscar paciente por DNI
    public Paciente findByDni(String dni) {
        return pacienteRepository.findByDni(dni);
    }

    // Eliminar paciente por ID
    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }
}

