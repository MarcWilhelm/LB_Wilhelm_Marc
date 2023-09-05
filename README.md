# M223 Praktischearbeit: CO-Workingspace

Repository:https://github.com/MarcWilhelm/LB_Wilhelm_Marc

Die Co-Workingspace Seite dient dazu um einen CO-Working space Online zu verwalten. Diese Bedeutet Buchungen erstellen. Meine Zusätzliche erwartung war ein Newsletter welchen man Abonieren kann.

## Aufsetzn des Projektes

1. Remote Container muss installiert sein.
1. Clone das Projekt lokal, um damit arbeiten zu können.
1. Öffne das Projekt mit Visual Studio Code.
1. Öffne das Projekt im Entwicklungscontainer.
1. Installiere die Quarkus Extension


## Projekt Starten

1. Projekt starten mit dem Kommando `Quarkus: Debug current Quarkus Project`
1. Die API sieht man mit Hilfe vom Swager UI auf http://localhost:8080/q/swagger-ui/.


##  Testdaten

Test daten werden Automatisch auf dem Server geladen es gibt die Beiden user:


Saskia(Mitglied):
- email: saskia@example.com
- passwort: passswort123

Felix(Admin):
- email: felix@example.com
- passwort: passswort456

Unter der URL: http://localhost:8080/users/signIn

Köntte man diese aufrufen diese Funktioniert Leider Nicht da ich an der Umsertzung gescheitert bin.