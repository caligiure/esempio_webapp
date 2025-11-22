# Avvia il backend:
    apri terminale nella cartella backend ed esegui:
    mvn spring-boot:run

# Avvia il frontend:
    apri terminale nella cartella frontend ed esegui:
    ng serve

# Documentazione Sistema: Spring Boot + Angular To-Do App

Questa applicazione è un esempio didattico di una Full Stack Web Application.
Ecco una spiegazione dettagliata di ogni componente.

## 1. Backend (Spring Boot)

Il backend è il "cervello" dell'applicazione. Gestisce i dati e la logica di business.

### Struttura
- **`pom.xml`**: È il file di configurazione di Maven. Definisce le dipendenze del progetto (Spring Web, JPA, H2, Lombok). È come la "lista della spesa" per il tuo progetto Java.
- **`DemoApplication.java`**: Il punto di ingresso dell'applicazione Spring Boot. Il metodo `main` avvia il server Tomcat integrato.
- **`model/Task.java`**: Questa è l'**Entity**. Rappresenta la struttura dei dati nel database. L'annotazione `@Entity` dice a Spring che questa classe corrisponde a una tabella nel database H2.
- **`repository/TaskRepository.java`**: Questo è il **Repository**. È un'interfaccia che estende `JpaRepository`. Spring implementa automaticamente questa interfaccia per fornirti metodi per interagire con il database (salvare, cercare, cancellare) senza scrivere SQL.
- **`service/TaskService.java`**: Questo è il **Service**. Contiene la logica di business. Fa da intermediario tra il Controller e il Repository. Qui potresti aggiungere validazioni o calcoli complessi.
- **`controller/TaskController.java`**: Questo è il **Controller**. Espone le API REST (gli endpoint URL) che il frontend chiamerà.
    - `@GetMapping`: Legge i dati.
    - `@PostMapping`: Crea nuovi dati.
    - `@PutMapping`: Aggiorna dati esistenti.
    - `@DeleteMapping`: Cancella dati.
    - `@CrossOrigin`: Permette al frontend (che gira su una porta diversa) di comunicare con il backend.

## 2. Frontend (Angular)

Il frontend è l'interfaccia utente. È ciò che l'utente vede e con cui interagisce.

### Struttura
- **`main.ts`**: Il punto di ingresso dell'applicazione Angular. Avvia il componente principale.
- **`app.config.ts`**: Configurazione globale dell'app (es. routing, http client).
- **`models/task.interface.ts`**: Definisce la "forma" di un oggetto Task in TypeScript. Serve per avere il controllo dei tipi e prevenire errori.
- **`services/task.service.ts`**: Questo è il **Service** Angular. Si occupa di comunicare con il backend. Usa `HttpClient` per fare richieste HTTP (GET, POST, ecc.) agli endpoint definiti nel `TaskController` Java.
- **`app.component.ts`**: La logica del componente principale. Gestisce la lista dei task, le funzioni per aggiungerne di nuovi o cancellarli. Chiama il `TaskService`.
- **`app.component.html`**: Il template HTML. Definisce la struttura della pagina (input, bottoni, lista). Usa la sintassi di Angular (es. `*ngFor`, `[(ngModel)]`) per rendere la pagina dinamica.
- **`app.component.css`**: Gli stili CSS per rendere l'applicazione gradevole alla vista.

## 3. Flusso dei Dati

1.  L'utente scrive un task e preme "Aggiungi" nel browser (**Frontend**).
2.  `AppComponent` cattura l'evento e chiama `TaskService.addTask()`.
3.  `TaskService` invia una richiesta HTTP POST a `http://localhost:8080/api/tasks`.
4.  Il **Backend** riceve la richiesta nel `TaskController`.
5.  Il `TaskController` passa i dati al `TaskService` (Java).
6.  Il `TaskService` usa il `TaskRepository` per salvare il task nel database H2.
7.  Il database conferma il salvataggio e il backend restituisce il task salvato al frontend.
8.  Angular aggiorna la lista a video.



# Walkthrough: Esecuzione e Verifica
Segui questa guida per avviare e verificare la tua applicazione.

1. Prerequisiti

    Assicurati di aver installato:
    - Java JDK 17+
    - Maven (opzionale se usi il wrapper, ma consigliato)
    - Node.js LTS
    - Angular CLI (npm install -g @angular/cli)

2. Avvio del Backend

    - Apri un terminale in esempio_webapp\backend.
    - Esegui il comando:
    mvn spring-boot:run
    (Se non hai maven installato globalmente ma hai il wrapper, usa ./mvnw spring-boot:run su Linux/Mac o mvnw spring-boot:run su Windows).
    - Attendi che appaia la scritta "Started DemoApplication". Il server è attivo su localhost:8080.

3. Setup e Avvio del Frontend

    - Segui le istruzioni in esempio_webapp\frontend-sources\istruzioni_frontend.md per creare il progetto e copiare i file.
    - Una volta avviato con ng serve, apri il browser su http://localhost:4200.

4. Verifica Manuale

    Esegui questi test per confermare il funzionamento:

    - Test 1: Visualizzazione Lista Vuota
        - Azione: Carica la pagina.
        - Risultato Atteso: Vedi il titolo "To-Do List" e nessun task.

    - Test 2: Aggiunta Task
        - Azione: Scrivi "Imparare Spring" nell'input e premi Invio o "Aggiungi".
        - Risultato Atteso: Il task appare nella lista. Se ricarichi la pagina, il task deve rimanere (perché salvato nel DB H2 in memoria).

    - Test 3: Completamento Task
        - Azione: Clicca sul testo del task.
        - Risultato Atteso: Il testo viene barrato (stile "completed").

    - Test 4: Eliminazione Task
        - Azione: Clicca sul pulsante "Elimina" rosso.
        - Risultato Atteso: Il task scompare dalla lista.

    Risoluzione Problemi Comuni

    - Errore CORS: Se vedi errori in console browser riguardo CORS, verifica che nel TaskController.java ci sia l'annotazione @CrossOrigin(origins = "http://localhost:4200").
    - Backend non parte: Verifica che la porta 8080 non sia occupata.