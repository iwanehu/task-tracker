# 📝 Task Tracker (CLI)

Task Tracker es una aplicación de línea de comandos escrita en **Java** que permite crear, listar, actualizar y gestionar tareas de forma sencilla.  
El proyecto utiliza almacenamiento en **JSON** para persistir los datos y está diseñado con una arquitectura modular y extensible.

El proyecto está disponible en GitHub:

🔗 [**https://github.com/iwanehu/task-tracker**](https://github.com/iwanehu/task-tracker)


---

## 🚀 Características

- Crear nuevas tareas con ID, descripción y estado.
- Listar todas las tareas o filtrarlas por estado.
- Actualizar tareas existentes.
- Marcar tareas como *in progress* o *done*.
- Eliminar tareas.
- Persistencia automática en archivo `tasks.json`.
- Arquitectura clara basada en:
  - `Task`
  - `TaskManager`
  - `CommandParser`
  - CLI interactiva

---

## 📂 Estructura del proyecto
src/
└── main/
└── java/
└── com/
└── tasktracker/
├── Task.java
├── TaskManager.java
├── CommandParser.java
└── Main.java

---

## 🛠 Requisitos

- Java 17+
- Maven 3.8+
- Git (opcional)

---

## ⚙️ Instalación

Clona el repositorio:

```bash
git clone https://github.com/iwanehu/task-tracker.git
cd task-tracker
```
Compila el proyecto:

```bash
mvn clean package
```

Ejecuta la aplicación:
bash
```bash
mvn exec:java
```


🖥 Uso del CLI
➕ Crear una tarea

```bash
add "Hacer tareas"
```

📋 Listar todas las tare

```bash
list
```

🔍 Listar por estado
```bash
list done
list todo
list in-progress
```

✏️ Actualizar descripción
```bash
update 3 "Nueva descripción"
```



🚦 Cambiar estado

```bash
mark-in-progress 3
mark-done 3
```


📦 Persistencia

Las tareas se guardan automáticamente en:

tasks.json

Cada tarea contiene:

{
  "id": 1,
  "description": "Ejemplo",
  "status": "TODO",
  "createdAt": "...",
  "updatedAt": "..."
}


👤 Autor

Snayder Prieto (iwanehu)  
📍 España
🔗 https://github.com/iwanehu


