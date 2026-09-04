package Proyecto.utilizando.arquitectura.hexagonal.application.usecases;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.AdditionalTaskInfo;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.ExternalServicePort;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.TaskRepositoryPort;

//Implementamos la interfaz useCase de la capa domain
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    //Implementamos un objeto de tipo ExternalServicePort
    private final ExternalServicePort externalServicePort;

    //Constructor de la clase
    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    //Metodos
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
