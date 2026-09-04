package Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.AdditionalTaskInfo;

//Clase interfaz que define los puertos de consumo para los objetos de tipo AdditionalTaskInfo
public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
