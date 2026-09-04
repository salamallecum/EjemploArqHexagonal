package Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;

//Clase interfaz que define la creacion de una tarea
public interface CreateTaskUseCase {

    Task createTask(Task newTask);
}
