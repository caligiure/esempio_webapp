package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service: Un service è un componente che contiene la logica di business.
@Service
public class TaskService {

    @Autowired // Inietta l'oggetto TaskRepository, cioè lo inizializza
    private TaskRepository taskRepository; // l'oggetto viene istanziato da Spring

    // Qui sono definiti metodi per interagire con il repository

    public List<Task> findAll() { // Restituisce tutti i task
        return taskRepository.findAll();
    }

    public Task save(Task task) { // Salva un task
        return taskRepository.save(task);
    }

    public Optional<Task> findById(Long id) { // Restituisce un task per ID
        return taskRepository.findById(id);
    }

    public void deleteById(Long id) { // Cancella un task per ID
        taskRepository.deleteById(id);
    }
}
