package ar.edu.centro8.turnos.Model;

import java.time.LocalDate;
import java.time.LocalTime;



import lombok.Getter;
import lombok.Setter;


@Getter @Setter


public class TurnoDTO {
    private Long nutricionistaId;
    private LocalDate fecha;
    private LocalTime hora;

   

    
}
