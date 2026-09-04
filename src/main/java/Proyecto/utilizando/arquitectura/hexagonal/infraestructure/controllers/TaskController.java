package Proyecto.utilizando.arquitectura.hexagonal.infraestructure.controllers;

import Proyecto.utilizando.arquitectura.hexagonal.application.services.TaskService;
import Proyecto.utilizando.arquitectura.hexagonal.domain.models.AdditionalTaskInfo;
import Proyecto.utilizando.arquitectura.hexagonal.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Clase controladora con los endpoints
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    //Constructor
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //EndPoint para registrar una tarea
    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    //EndPoint para consultar una tarea por su id
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId){
        return taskService.getTask(taskId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //EndPoint para obtener el listadso de tareas
    @GetMapping("/allTasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    //EndPoint para actualizar una tarea
    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task taskEdit){
        return taskService.updateTask(taskEdit)
                .map(task -> new ResponseEntity<>(task, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //EndPoint para eliminar una tarea
    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long taskId){
        //Validamos si existe la tarea para eliminarla
        if(taskService.deleteTask(taskId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //EndPoint que consulta la info adicional de una tarea (servicio externo)
    @GetMapping("/additionalInfo/{taskId}")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalInfo(@PathVariable Long taskId){
        AdditionalTaskInfo addInfo = taskService.getAdditionalTaskInfo(taskId);
        return new ResponseEntity<>(addInfo, HttpStatus.OK);
    }

}
