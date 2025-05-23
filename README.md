```markdown
# 📚 SistemaLibreria

Un sistema modular de gestión de biblioteca desarrollado en Java con un enfoque orientado a objetos, principios SOLID y arquitectura por capas. Diseñado para ser mantenible, extensible y fácil de probar.

---

## 🚀 Funcionalidades actuales

- 📘 Registro, edición y eliminación de libros.
- 👤 Gestión de usuarios (alta, baja, modificación).
- 🔐 Verificación de credenciales con hash seguro (BCrypt).
- 🔄 Registro de préstamos y devoluciones.
- 💾 Simulación de persistencia en memoria (`MemoryUserRepository`, `MemoryBookRepository`).
- 🧪 Pruebas unitarias con JUnit para repositorios y utilidades.
- 🧱 Separación en capas: `model`, `service`, `repository`, `DTO`, `adapter`, `interfaces`.

---

## 🔧 Tecnologías y herramientas

- Java 17+
- JUnit 5
- BCrypt (para hashing de contraseñas)
- Maven (gestión de dependencias)
- IDE: IntelliJ IDEA

---

## 🛣️ Mejoras en curso / futuras implementaciones

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

---

## 🏗️ Estructura del proyecto

`
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
`

---

## 🧠 Autores y contribución

Este proyecto fue desarrollado como parte de un proyecto académico, con enfoque en buenas prácticas de desarrollo de software.  
Las contribuciones están abiertas para quienes deseen extender o profesionalizar el sistema.

---

## 📄 Licencia

MIT 
```
