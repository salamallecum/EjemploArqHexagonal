package Proyecto.utilizando.arquitectura.hexagonal.application.services;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.AdditionalTaskInfo;
import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

//Clase que implementa la lógica de negocio definida para las tareas en la capa domain (interfaces usecases)
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    //Traemos objetos del tipo useCase de la capa domain
    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    //Definimos el constructor de la clase a partir de los objetos de capa domain
    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase, UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    //Registro de una tarea
    @Override
    public Task createTask(Task newTask) {
        return createTaskUseCase.createTask(newTask);
    }

    //Eliminacion de una tarea
    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    //Obtener la informacion dekl detalle de una tarea mediante su id
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    //Consultar una tarea
    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    //Consulta todas las tareas
    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    //Actualiza una tarea
    @Override
    public Optional<Task> updateTask(Task taskEdit) {
        return updateTaskUseCase.updateTask(taskEdit);
    }
}
