package Proyecto.utilizando.arquitectura.hexagonal.application.usecases;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in.RetrieveTaskUseCase;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

//Implementamos la interfaz useCase de la capa domain
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    //Implementamos un objeto de tipo TaskRepositoryPort
    private final TaskRepositoryPort taskRepositoryPort;

    //Constructor de la clase
    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //Metodos
    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
