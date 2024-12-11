package ar.edu.centro8.turnos.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
public class Paciente {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private int telefono;


    // Relación con Turno
    @OneToMany(mappedBy = "paciente")
    private List<Turno> turnos;

    // Relación con Facturación
    @OneToMany(mappedBy = "paciente")
    private List<Facturacion> facturas;

    public Paciente() {
    }

    
}
