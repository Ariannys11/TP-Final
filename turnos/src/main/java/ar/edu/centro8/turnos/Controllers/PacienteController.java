package ar.edu.centro8.turnos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ar.edu.centro8.turnos.Model.Paciente;
import ar.edu.centro8.turnos.Service.PacienteService;

import java.util.List;


@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Crear 
    @PostMapping
    public Paciente save(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    // Obtener todos los pacientes
    @GetMapping
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }


    // Obtener paciente por DNI
    @GetMapping("/dni/{dni}")
    public Paciente findByDni(@PathVariable String dni) {
        return pacienteService.findByDni(dni);
    }

    // Eliminar paciente por ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }
}

