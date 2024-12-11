package ar.edu.centro8.turnos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ar.edu.centro8.turnos.Model.Facturacion;
import ar.edu.centro8.turnos.Service.FacturacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @PostMapping
    public Facturacion save(@RequestBody Facturacion facturacion) {
        return facturacionService.save(facturacion);
    }

    @GetMapping
    public List<Facturacion> findAll() {
        return facturacionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Facturacion> findById(@PathVariable Long id) {
        return facturacionService.findById(id);
    }

    @GetMapping("/metodo-pago/{metodoPago}")
    public List<Facturacion> findByMetodoPago(@PathVariable String metodoPago) {
        return facturacionService.findByMetodoPago(metodoPago);
    }

    @GetMapping("/turno/{idTurno}")
    public List<Facturacion> findByTurno(@PathVariable Long idTurno) {
        return facturacionService.findByTurno(idTurno);
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<Facturacion> findByPaciente(@PathVariable Long idPaciente) {
        return facturacionService.findByPaciente(idPaciente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        facturacionService.deleteById(id);
    }
}

