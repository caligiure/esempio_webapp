# Istruzioni per il Frontend Angular

Poiché Node.js non era disponibile durante la creazione automatica, ho preparato i file sorgente necessari in questa cartella.

Segui questi passaggi una volta installato Node.js e Angular CLI:

1.  **Installa Angular CLI** (se non l'hai già fatto):
    ```bash
    npm install -g @angular/cli
    ```

2.  **Crea il progetto Angular**:
    Apri un terminale nella cartella `c:\antigravity\esempio_webapp` ed esegui:
    ```bash
    ng new frontend --standalone --routing --style css
    ```
    (Rispondi 'N' se ti chiede di SSR per semplicità, o 'Y' se preferisci).

3.  **Copia i file sorgente**:
    Copia il contenuto della cartella `frontend-sources/src` dentro `frontend/src`, sovrascrivendo i file esistenti se richiesto.
    
    In particolare assicurati di copiare:
    - `app/models/`
    - `app/services/`
    - `app/app.component.*`
    - `app/app.config.ts`

4.  **Avvia il Frontend**:
    Entra nella cartella `frontend`:
    ```bash
    cd frontend
    ng serve
    ```
    L'applicazione sarà disponibile su `http://localhost:4200`.

## Nota su `app.routes.ts`
Se il comando `ng new` ha creato un file `app.routes.ts`, assicurati che esista. Il file `app.config.ts` che ho fornito lo importa. Se non esiste, crealo vuoto:
```typescript
import { Routes } from '@angular/router';
export const routes: Routes = [];
```
