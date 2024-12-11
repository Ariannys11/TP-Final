package ar.edu.centro8.turnos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ar.edu.centro8.turnos.Model.Nutricionista;
import ar.edu.centro8.turnos.Service.NutricionistaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nutricionistas")
public class NutricionistaController {

    @Autowired
    private NutricionistaService nutricionistaService;

    // Crear 
    @PostMapping
    public Nutricionista save(@RequestBody Nutricionista nutricionista) {
        return nutricionistaService.save(nutricionista);
    }

    // Obtener todos los nutricionistas
    @GetMapping
    public List<Nutricionista> findAll() {
        return nutricionistaService.findAll();
    }

    // Obtener nutricionista por ID
    @GetMapping("/{id}")
    public Optional<Nutricionista> findById(@PathVariable Long id) {
        return nutricionistaService.findById(id);
    }

    // Obtener nutricionistas por especialidad
    @GetMapping("/especialidad/{especialidad}")
    public List<Nutricionista> findByEspecialidad(@PathVariable String especialidad) {
        return nutricionistaService.findByEspecialidad(especialidad);
    }

    // Eliminar nutricionista por ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        nutricionistaService.deleteById(id);
    }
}
