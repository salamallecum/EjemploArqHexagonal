package Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in;

//Clase interfaz que permite eliminar unba tarea mediante su is
public interface DeleteTaskUseCase {

    boolean deleteTask(Long id);
}
