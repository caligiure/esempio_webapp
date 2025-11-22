import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.interface';

// Un service è un componente che contiene la logica di business

@Injectable({
    providedIn: 'root' // indica che questo service è disponibile in tutto l'applicazione
})
export class TaskService {
    private apiUrl = 'http://localhost:8080/api/tasks'; // URL del backend

    constructor(private http: HttpClient) { } // HttpClient è un service di Angular che permette di fare richieste HTTP

    // Consulta TaskController.java nel backend per capire come sono mappate le richieste HTTP

    getTasks(): Observable<Task[]> {
        return this.http.get<Task[]>(this.apiUrl); // restituisce tutti i task
    }

    addTask(task: Task): Observable<Task> {
        return this.http.post<Task>(this.apiUrl, task); // aggiunge un task
    }

    updateTask(task: Task): Observable<Task> {
        return this.http.put<Task>(`${this.apiUrl}/${task.id}`, task); // aggiorna un task
    }

    deleteTask(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`); // cancella un task
    }
}
