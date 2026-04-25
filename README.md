# Java Contacts Manager

Un'applicazione Java per la gestione di una rubrica contatti personale.  
Progetto sviluppato per consolidare i concetti fondamentali della programmazione a oggetti (OOP) in Java.

## Tecnologie Utilizzate

- **Java 17**: Core language
- **Maven**: Gestione delle dipendenze e build automation
- **Lombok**: Riduzione del boilerplate code (Getter, Setter, Constructor)
- **Stream API**: Ricerca e manipolazione delle collezioni
- **Git**: Controllo di versione

## Funzionalità Principali

- Aggiunta di nuovi contatti
- Ricerca per nome o numero di telefono
- Eliminazione di un contatto esistente
- Visualizzazione di tutti i contatti
- Persistenza dei dati su file di testo

## Architettura del Progetto

Il progetto segue una **Layered Architecture** per separare le responsabilità:

- **Model**: Definisce l'entità `Contatto`
- **Service**: Contiene la logica di business
- **Repository**: Gestisce la persistenza dei dati su file
- **App**: Punto di ingresso dell'applicazione (Main)

## Come avviare il progetto

1. Clona il repository:
   ```bash
   git clone https://github.com/docpezza/Java-Contacs-Manager.git
"# Java-Core-Mastery" 
