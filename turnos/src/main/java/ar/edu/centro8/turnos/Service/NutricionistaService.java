package ar.edu.centro8.turnos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.centro8.turnos.Model.Nutricionista;
import ar.edu.centro8.turnos.Repository.INutricionistaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NutricionistaService {

    @Autowired
    private INutricionistaRepository nutricionistaRepository;

    // Crear 
    public Nutricionista save(Nutricionista nutricionista) {
         Nutricionista existingNutricionista = nutricionistaRepository.findByMatricula(nutricionista.getMatricula());
        if (existingNutricionista != null && !existingNutricionista.getId().equals(nutricionista.getId())) {
            throw new IllegalArgumentException("Ya existe un paciente con el mismo DNI");
        }
        return nutricionistaRepository.save(nutricionista);
    }


    // Obtener todos los nutricionistas
    public List<Nutricionista> findAll() {
        return nutricionistaRepository.findAll();
    }

    // Buscar nutricionista por ID
    public Optional<Nutricionista> findById(Long id) {
        return nutricionistaRepository.findById(id);
    }

    // Buscar nutricionistas por especialidad
    public List<Nutricionista> findByEspecialidad(String especialidad) {
        return nutricionistaRepository.findByEspecialidad(especialidad);
    }

    // Eliminar nutricionista por ID
    public void deleteById(Long id) {
        nutricionistaRepository.deleteById(id);
    }
}

