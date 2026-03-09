import app.Agenda;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaTest {

    @BeforeEach
    void setUp() {
        Agenda.limpiarTareas();
    }

    @Test
    void testAgregarTarea() {
        Agenda.agregarTarea("Estudiar GitHub Actions");
        assertEquals(1, Agenda.totalTareas());
    }

    @Test
    void testEliminarTarea() {
        Agenda.agregarTarea("Hacer tarea");
        Agenda.eliminarTarea(0);
        assertEquals(0, Agenda.totalTareas());
    }

    @Test
    void testCompletarTarea() {
        Agenda.agregarTarea("Practicar Java");
        Agenda.completarTarea(0);
        assertTrue(Agenda.estaCompletada(0));
    }
}