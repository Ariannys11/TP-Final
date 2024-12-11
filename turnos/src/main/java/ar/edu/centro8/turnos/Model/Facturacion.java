package ar.edu.centro8.turnos.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor

@NamedQuery(name = "Facturacion.findByTurno",
           query = "SELECT f FROM Facturacion f WHERE f.turno.id = :idTurno")

@NamedQuery(name = "Facturacion.findByPaciente",
            query = "SELECT f FROM Facturacion f WHERE f.paciente.id = :idPaciente")

public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;
    private String metodoPago;

    // Relación con Turno
    @OneToOne
    @JoinColumn(name = "id_turno")
    private Turno turno;

    // Relación con Paciente
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public Facturacion() {
    }

   
}
