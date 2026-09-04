package Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.AdditionalTaskInfo;

//Clase interface que obtiene la info de un AdditionalTask
public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(long id);
}
