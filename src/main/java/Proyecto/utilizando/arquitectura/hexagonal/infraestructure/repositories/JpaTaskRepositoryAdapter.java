package Proyecto.utilizando.arquitectura.hexagonal.infraestructure.repositories;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.TaskRepositoryPort;
import Proyecto.utilizando.arquitectura.hexagonal.infraestructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Clase adaptador que define los metodos CRUD
@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    //Definimos un objeto de tipo JpataskRepository
    private final JpaTaskRepository jpaTaskRepository;

    //Constructor
    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    //Metodos
    //Registra una tarea
    @Override
    public Task save(Task newTask) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(newTask);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    //Consultar una tarea por su id
    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    //Consultar la totalidad de tareas
    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    //Actualizar una tarea
    @Override
    public Optional<Task> updateTask(Task taskEdit) {
        //Validamos que la tarea exista por su id
        if(jpaTaskRepository.existsById(taskEdit.getId())){
            TaskEntity taskEntity = TaskEntity.fromDomainModel(taskEdit);
            TaskEntity updateTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updateTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        //Validamos que la tarea exista por su id para eliminarla
        if(jpaTaskRepository.existsById(id)){
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
