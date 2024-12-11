package ar.edu.centro8.turnos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.centro8.turnos.Model.Paciente;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
   
    //Metodo personalizado
    Paciente findByDni(String dni); 
}

