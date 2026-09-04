package Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;


//Clase interfaz que define los puertos de consumo para los objetos de tipo Task
public interface TaskRepositoryPort {

    //Registra una tarea
    Task save(Task newTask);

    //Consulta una tarea mediante id
    Optional<Task> findById(Long id);

    //Consulta todas las tareas
    List<Task> findAll();

    //Actualiza una tarea
    Optional<Task> updateTask(Task taskEdit);

    //Elimina una tarea
    boolean deleteById(Long id);


}
