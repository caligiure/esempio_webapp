package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController: Indica che questa classe gestisce richieste REST e restituisce JSON.
// @RequestMapping("/api/tasks"): Prefisso per tutti gli endpoint di questo controller.
// @CrossOrigin(origins = "http://localhost:4200"): Permette al frontend Angular di chiamare queste API.
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    // Inietta l'oggetto TaskService, cioè lo inizializza
    @Autowired
    private TaskService taskService;

    // Consulta TaskService.java per capire cosa fanno i metodi a cui sono mappate
    // le richieste HTTP

    // @GetMapping: Indica che questo metodo gestisce le richieste GET.
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    // @PostMapping: Indica che questo metodo gestisce le richieste POST.
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    // @PutMapping: Indica che questo metodo gestisce le richieste PUT.
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id); // Assicura che l'ID sia quello corretto
        return taskService.save(task);
    }

    // @DeleteMapping: Indica che questo metodo gestisce le richieste DELETE.
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }
}
