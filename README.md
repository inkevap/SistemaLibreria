# 📚 SistemaLibreria

Un sistema de gestión de biblioteca desarrollado en Java, orientado a objetos y siguiendo principios SOLID. Permite manejar libros, usuarios y préstamos de forma modular, con enfoque en mantenibilidad, escalabilidad y calidad de código.

---

## 🚀 Funcionalidades

- 📘 Registro, edición y eliminación de libros.
- 👤 Gestión de usuarios (alta, baja, modificación).
- 🔄 Registro de préstamos y devoluciones.
- 💾 Simulación de persistencia en memoria.
- 🧪 Pruebas unitarias con JUnit.
- 🧱 Arquitectura orientada a servicios e interfaces.

---

## 🧠 Tecnologías y Principios Usados

- **Java 17**
- **Maven** para gestión de dependencias
- **JUnit** para pruebas unitarias
- **Principios SOLID**
   - S: Single Responsibility
   - O: Open/Closed
   - L: Liskov Substitution
   - I: Interface Segregation
   - D: Dependency Inversion
- Estructura en capas: `model`, `interfaces`, `services`, `util`, `test`

---

## 🗂️ Estructura del Proyecto

```bash
SistemaLibreria/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── sistemalibreria/
│   │   │   │   ├── model/           # Clases Libro, Usuario, Prestamo
│   │   │   │   ├── interfaces/      # Repositorios y contratos
│   │   │   │   ├── services/        # Lógica de negocio
│   │   │   │   ├── util/            # Utilidades como BookUpdater
│   ├── test/
│   │   ├── java/
│   │   │   ├── sistemalibreria/     # Pruebas unitarias con JUnit
├── pom.xml                         # Gestión de dependencias con Maven
```

---

## ⚙️ Ejecución del Proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/inkevap/SistemaLibreria.git
```

2. Importa el proyecto como un proyecto **Maven** en tu IDE (IntelliJ, Eclipse, etc).

3. Ejecuta desde la clase `Main.java`.

4. Ejecuta las pruebas con:

```bash
mvn test
```

---

## ✅ Pruebas

Este proyecto incluye pruebas unitarias en la carpeta `test/`, cubriendo:

- 📗 Actualización de libros (`BookUpdaterTest`)
- 👤 Lógica de usuarios
- 🔁 Operaciones de préstamo

Frameworks usados:
- `JUnit 5`

---

## 💡 Futuras Mejoras

- Persistencia real (JDBC, Hibernate o JPA)
- Interfaz gráfica o web (Swing, JavaFX o Spring MVC)
- Implementación de patrón DAO
- Validaciones más robustas

---

## 👨‍💻 Autor

Desarrollado por [inkevap](https://github.com/inkevap) como proyecto de aprendizaje avanzado en Java.

---

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más información.

