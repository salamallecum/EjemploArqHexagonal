package Proyecto.utilizando.arquitectura.hexagonal.application.usecases;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in.UpdateTaskUseCase;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    //Implementamos un objeto de tipo TaskRepositoryPort
    private final TaskRepositoryPort taskRepositoryPort;

    //Constructor de la clase
    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //Metodos
    @Override
    public Optional<Task> updateTask(Task taskEdit) {
        return taskRepositoryPort.updateTask(taskEdit);
    }
}
