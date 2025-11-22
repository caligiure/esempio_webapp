import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Task } from './models/task.interface';
import { TaskService } from './services/task.service';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    tasks: Task[] = [];
    newTaskDescription: string = '';

    constructor(private taskService: TaskService) { }

    ngOnInit(): void {
        this.loadTasks();
    }

    loadTasks(): void {
        this.taskService.getTasks().subscribe(tasks => {
            console.log('Tasks loaded:', tasks);
            this.tasks = tasks;
        });
    }

    addTask(): void {
        if (!this.newTaskDescription.trim()) return;

        const newTask: Task = {
            description: this.newTaskDescription,
            completed: false
        };

        this.taskService.addTask(newTask).subscribe(task => {
            this.tasks.push(task);
            this.newTaskDescription = '';
        });
    }

    toggleCompletion(task: Task): void {
        task.completed = !task.completed;
        this.taskService.updateTask(task).subscribe();
    }

    deleteTask(id: number | undefined): void {
        if (id === undefined) return;
        this.taskService.deleteTask(id).subscribe(() => {
            this.tasks = this.tasks.filter(t => t.id !== id);
        });
    }
}
