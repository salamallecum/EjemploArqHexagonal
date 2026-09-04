package Proyecto.utilizando.arquitectura.hexagonal.infraestructure.entities;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//Clase que define la entidad de base de datos de una tarea
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el Id será autoincrementable
    private Long Id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private boolean completed;

    //Construye los objetos taskentity a partir del modelo Task definido en la capa domain
    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.isCompleted());
    }

    //Permite retornar una objeto modelo de tipo task con la información de la entidad
    public Task toDomainModel(){
        return new Task(Id, title, description, creationDate, completed);
    }

}
