package Proyecto.utilizando.arquitectura.hexagonal.infraestructure.adapters;

import Proyecto.utilizando.arquitectura.hexagonal.domain.models.AdditionalTaskInfo;
import Proyecto.utilizando.arquitectura.hexagonal.domain.ports.out.ExternalServicePort;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//Clase que emula un adaptador que se conecta a un servicio externo
public class ExternalServiceAdapter implements ExternalServicePort {

    //Urls de servicios externos
    //https://jsonplaceholder.typicode.com/todos/
    //https://jsonplaceholder.typicode.com/users/

    private final RestTemplate restTemplate;

    //Constructor
    public ExternalServiceAdapter() {
        restTemplate = new RestTemplate();
    }

    //Obtiene la infromación adicional del servicio externo
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + id;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        //Evaluamos si la informacion adicional recibida es nula
        if(todo == null){
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> user = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser userJson = user.getBody();

        //Evaluamos si la informacion adicional recibida es nula
        if(userJson == null){
            return null;
        }
        return new AdditionalTaskInfo(userJson.getId(), userJson.getName(), userJson.getEmail());

    }

    //Creamos dos clases internas para el manejo de la informacion de los servicios externos
    @Setter
    @Getter
    private static class JsonPlaceHolderTodo{
        private Long id;
        private Long userId;
    }

    @Setter
    @Getter
    private static class JsonPlaceHolderUser{
        private Long id;
        private String name;
        private String email;
    }
}
