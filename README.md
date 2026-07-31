# 📚 SistemaLibreria

🇪🇸 [Español](#-español) | 🇬🇧 [English](#-english)

---

## 🇪🇸 Español

Un sistema modular de gestión de biblioteca desarrollado en Java con un enfoque orientado a objetos, principios SOLID y arquitectura por capas. Diseñado para ser mantenible, extensible y fácil de probar.

### 🚀 Funcionalidades actuales

- 📘 Registro, edición y eliminación de libros.
- 👤 Gestión de usuarios (alta, baja, modificación).
- 🔐 Verificación de credenciales con hash seguro (BCrypt).
- 🔄 Registro de préstamos y devoluciones.
- 💾 Simulación de persistencia en memoria (`MemoryUserRepository`, `MemoryBookRepository`).
- 🧪 Pruebas unitarias con JUnit para repositorios y utilidades.
- 🧱 Separación en capas: `model`, `service`, `repository`, `DTO`, `adapter`, `interfaces`.

### 🔧 Tecnologías y herramientas

- Java 17+
- JUnit 5
- BCrypt (para hashing de contraseñas)
- Maven (gestión de dependencias)
- IDE: IntelliJ IDEA

### 🛣️ Mejoras en curso / futuras implementaciones

- ✅ **Inyección de dependencias vía `AppConfig`**
  - Eliminar instanciación directa en `Main`.
  - Facilitar pruebas e intercambio de implementaciones (por ejemplo, pasar de memoria a base de datos).

- 🌐 **Soporte multilenguaje (internacionalización)**
  - Código en inglés.
  - Interfaz en español (usando `ResourceBundle` con `messages_es.properties`).

- 🧩 Mejora de pruebas
  - Añadir pruebas unitarias para servicios y controladores de CLI.
  - Simular entradas de usuario y flujos completos.

- 🧽 Limpieza de dependencias
  - Reemplazo de dependencias a clases concretas por interfaces (`BCryptUtils`, adaptadores, etc.)

- 🗂️ Refactorización general
  - Renombrar clases como `CommandLineInterfazSystem` a nombres consistentes en inglés.
  - Separar lógica de presentación de la lógica de negocio más claramente.

### 🏗️ Estructura del proyecto

```
SistemaLibreria/
├── src/
│   ├── main/java/sistemalibreria/
│   │   ├── model/             # Clases de dominio (User, Book, etc.)
│   │   ├── repository/        # Repositorios en memoria
│   │   ├── service/           # Lógica de negocio
│   │   ├── util/              # Funciones auxiliares
│   │   ├── interfaces/        # Contratos (interfaces)
│   │   ├── adapter/           # Adaptadores entre modelos
│   │   ├── DTO/               # Data Transfer Objects
│   │   └── Main.java          # Punto de entrada
│   └── test/java/...          # Pruebas unitarias
├── pom.xml                    # Configuración de Maven
└── README.md
```

### 🧠 Autores y contribución

Este proyecto fue desarrollado como parte de un proyecto académico, con enfoque en buenas prácticas de desarrollo de software.
Las contribuciones están abiertas para quienes deseen extender o profesionalizar el sistema.

### 📄 Licencia

MIT

---

## 🇬🇧 English

A modular library management system built in Java with an object-oriented approach, SOLID principles, and a layered architecture. Designed to be maintainable, extensible, and easy to test.

### 🚀 Current Features

- 📘 Book registration, editing, and deletion.
- 👤 User management (create, delete, update).
- 🔐 Credential verification with secure hashing (BCrypt).
- 🔄 Loan and return tracking.
- 💾 In-memory persistence simulation (`MemoryUserRepository`, `MemoryBookRepository`).
- 🧪 Unit tests with JUnit for repositories and utilities.
- 🧱 Layered separation: `model`, `service`, `repository`, `DTO`, `adapter`, `interfaces`.

### 🔧 Technologies and Tools

- Java 17+
- JUnit 5
- BCrypt (for password hashing)
- Maven (dependency management)
- IDE: IntelliJ IDEA

### 🛣️ Ongoing / Future Improvements

- ✅ **Dependency injection via `AppConfig`**
  - Remove direct instantiation in `Main`.
  - Make it easier to test and swap implementations (e.g., moving from in-memory to a database).

- 🌐 **Multi-language support (i18n)**
  - Codebase in English.
  - Interface in Spanish (using `ResourceBundle` with `messages_es.properties`).

- 🧩 Test improvements
  - Add unit tests for services and CLI controllers.
  - Simulate user input and complete flows.

- 🧽 Dependency cleanup
  - Replace dependencies on concrete classes with interfaces (`BCryptUtils`, adapters, etc.)

- 🗂️ General refactoring
  - Rename classes like `CommandLineInterfazSystem` to consistent English names.
  - More clearly separate presentation logic from business logic.

### 🏗️ Project Structure

```
SistemaLibreria/
├── src/
│   ├── main/java/sistemalibreria/
│   │   ├── model/             # Domain classes (User, Book, etc.)
│   │   ├── repository/        # In-memory repositories
│   │   ├── service/           # Business logic
│   │   ├── util/              # Helper functions
│   │   ├── interfaces/        # Contracts (interfaces)
│   │   ├── adapter/           # Adapters between models
│   │   ├── DTO/               # Data Transfer Objects
│   │   └── Main.java          # Entry point
│   └── test/java/...          # Unit tests
├── pom.xml                    # Maven configuration
└── README.md
```

### 🧠 Authors and Contributing

This project was developed as part of an academic assignment, with a focus on good software development practices.
Contributions are welcome from anyone who wants to extend or professionalize the system.

### 📄 License

MIT
