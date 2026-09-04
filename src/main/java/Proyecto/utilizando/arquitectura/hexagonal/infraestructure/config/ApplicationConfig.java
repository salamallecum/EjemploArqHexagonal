package Proyecto.utilizando.arquitectura.hexagonal.infraestructure.config;

import Proyecto.utilizando.arquitectura.hexagonal.application.services.TaskService;
import Proyecto.utilizando.arquitectura.hexagonal.application.usecases.*;
import Proyecto.utilizando.arquitectura.hexagonal.domain.models.AdditionalTaskInfo;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.ExternalServicePort;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.TaskRepositoryPort;
import Proyecto.utilizando.arquitectura.hexagonal.infraestructure.adapters.ExternalServiceAdapter;
import Proyecto.utilizando.arquitectura.hexagonal.infraestructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Clase que define la configuración de la aplicación e incializa objetos
@Configuration
public class ApplicationConfig {

    //Inicializa un objeto de tipo TaskService
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    //Inicializa un objeto de tipo TaskRepositoryPort
    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
         return jpaTaskRepositoryAdapter;
    }

    //Inicializa un objeto de tipo GetAdditionalInfoUseCase
    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    //Inicializa un objeto de tipo ExternalServicePort
    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }

}
