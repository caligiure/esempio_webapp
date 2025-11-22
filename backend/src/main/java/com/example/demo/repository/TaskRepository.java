package com.example.demo.repository;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository: Una repository è un componente che gestisce l'accesso ai dati.
// In questo caso, gestisce le operazioni CRUD (Create, Read, Update, Delete) per i task.
// Estendendo JpaRepository, otteniamo automaticamente metodi come save(), findAll(), deleteById(), ecc.
// E' tipizzata con Task e Long, cioè con la classe Task e il tipo di ID (Long).
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
