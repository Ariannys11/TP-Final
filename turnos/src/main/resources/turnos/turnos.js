// Obtener los botones y las secciones
const solicitarTurnoBtn = document.getElementById('solicitar-turno-btn');
const formularioTurno = document.getElementById('formulario-turno');
const verTurnosBtn = document.getElementById('ver-turnos');
const verTurnosSection = document.getElementById('ver-turnos-section');

// Evento para mostrar/ocultar el formulario de agendar turno
solicitarTurnoBtn.addEventListener('click', () => {
    if (formularioTurno.style.display === 'none') {
        formularioTurno.style.display = 'block'; // Mostrar formulario
        verTurnosSection.style.display = 'none'; // Ocultar la sección de turnos
        solicitarTurnoBtn.textContent = 'Cancelar Solicitud'; // Cambiar texto del botón
    } else {
        formularioTurno.style.display = 'none'; // Ocultar formulario
        solicitarTurnoBtn.textContent = 'Solicitar Turno'; // Volver al texto original del botón
    }
});

// Evento para mostrar la lista de turnos
verTurnosBtn.addEventListener('click', () => {
    verTurnosSection.style.display = 'block'; // Mostrar sección de turnos
    formularioTurno.style.display = 'none'; // Ocultar formulario
});
