package Proyecto.utilizando.arquitectura.hexagonal.application.usecases;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in.CreateTaskUseCase;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.TaskRepositoryPort;

//Implementamos la interfaz useCase de la capa domain
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    //Implementamos un objeto de tipo TaskRepositoryPort
    private final TaskRepositoryPort taskRepositoryPort;

    //Constructor de la clase
    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //Metodos
    @Override
    public Task createTask(Task newTask) {
        return taskRepositoryPort.save(newTask);
    }
}
