package lk.ijse.dep11.todo.api;

import lk.ijse.dep11.todo.to.TaskTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskHttpController {

    /*
        The schema object defines the content of the request and response. In other words,
        it refers to the definition and set of rules (validation rules) for representing
        the structure of API data
    */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public TaskTO createTask(@RequestBody TaskTO task) {
        System.out.println("createTask()");
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{id}", consumes = "application/json")
    public void updateTask(@PathVariable String id,
                           @RequestBody TaskTO task) {
        System.out.println("updateTask()");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") String taskId) {
        System.out.println("deleteTask()");
    }

    /* @ResponseStatus(HttpStatus.OK) */
    @GetMapping(produces = "application/json")
    public List<TaskTO> getAllTasks() {
        System.out.println("getAllTasks()");
        return null;
    }
}
