// Interfaccia che rappresenta la struttura di un task
export interface Task {
  id?: number; // ? indica che il campo è opzionale
  description: string;
  completed: boolean;
}
