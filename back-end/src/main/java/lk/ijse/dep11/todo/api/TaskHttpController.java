package lk.ijse.dep11.todo.api;

import lk.ijse.dep11.todo.to.TaskTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskHttpController {

    @PostMapping
    public TaskTO createTask(@RequestBody String description) {
        System.out.println("createTask()");
        return new TaskTO(1, description, false);
    }

    @GetMapping
    public List<TaskTO> getAllTasks() {
        System.out.println("getAllTasks()");
        return new ArrayList<>();
    }

    // PATCH /tasks/{id}
    @PatchMapping("/{id}")
    public void updateTask(@PathVariable("id") String taskId,
                           @RequestBody Map<String, String> params) {
        System.out.println("updateTask()");
    }

    // DELETE /tasks/{id}
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        System.out.println("deleteTask()");
    }
}
