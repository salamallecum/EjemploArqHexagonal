package Proyecto.utilizando.arquitectura.hexagonal.application.usecases;

import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in.DeleteTaskUseCase;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.TaskRepositoryPort;

//Implementamos la interfaz useCase de la capa domain
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    //Implementamos un objeto de tipo TaskRepositoryPort
    private final TaskRepositoryPort taskRepositoryPort;

    //Constructor de la clase
    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //Metodos
    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }
}
