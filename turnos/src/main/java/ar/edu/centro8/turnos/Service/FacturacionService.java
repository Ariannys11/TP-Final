package ar.edu.centro8.turnos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.centro8.turnos.Model.Facturacion;
import ar.edu.centro8.turnos.Repository.IFacturacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionService {

    @Autowired
    private IFacturacionRepository facturacionRepository;

    public Facturacion save(Facturacion facturacion) {
        return facturacionRepository.save(facturacion);
    }

    public List<Facturacion> findAll() {
        return facturacionRepository.findAll();
    }

    public Optional<Facturacion> findById(Long id) {
        return facturacionRepository.findById(id);
    }

    public List<Facturacion> findByMetodoPago(String metodoPago) {
        return facturacionRepository.findByMetodoPago(metodoPago);
    }

    public List<Facturacion> findByTurno(Long idTurno) {
        return facturacionRepository.findByTurno(idTurno);
    }

    public List<Facturacion> findByPaciente(Long idPaciente) {
        return facturacionRepository.findByPaciente(idPaciente);
    }

    public void deleteById(Long id) {
        facturacionRepository.deleteById(id);
    }
}

