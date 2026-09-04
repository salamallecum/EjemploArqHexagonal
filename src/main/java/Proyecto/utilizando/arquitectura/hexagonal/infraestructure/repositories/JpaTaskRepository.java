package Proyecto.utilizando.arquitectura.hexagonal.infraestructure.repositories;

import Proyecto.utilizando.arquitectura.hexagonal.infraestructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Clase repository
@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
