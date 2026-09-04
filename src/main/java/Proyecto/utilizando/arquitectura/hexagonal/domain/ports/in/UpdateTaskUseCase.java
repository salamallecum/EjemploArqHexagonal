package Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;

import java.util.Optional;

//Clase interfaz que define la actualización de una tarea
public interface UpdateTaskUseCase {

    Optional<Task> updateTask(Task taskEdit);
}
