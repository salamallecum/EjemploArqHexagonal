package Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

//Clase interfaz que permite obtener una o más tareas
public interface RetrieveTaskUseCase {

    //Obtenemos una tarea por su id
    Optional<Task> getTask(Long id);

    //Obtenemos el total de tareas
    List<Task> getAllTasks();
}
