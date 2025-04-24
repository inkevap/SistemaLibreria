# 📚 SistemaLibreria

Sistema de gestión para una librería. Proyecto académico en Java que implementa una arquitectura orientada a objetos con énfasis en principios **SOLID**.

> "Diseñado para ser escalable, mantenible y educativo."

---

## 🧾 Descripción

Este sistema permite administrar libros, usuarios y préstamos de manera estructurada. Está diseñado para mantener un **bajo acoplamiento** y **alta cohesión**, utilizando main.interfaces, clases modelo, servicios y una posible capa futura de persistencia.

---

## 🚀 Funcionalidades principales

- 📘 CRUD de libros
- 👤 CRUD de usuarios
- 📕 Gestión de préstamos de libros
- 💾 Persistencia simulada (por implementar con base de datos o archivo)
- 🧠 Uso de buenas prácticas de diseño y arquitectura

---

## 🧱 Estructura del proyecto

```bash
SistemaLibreria/
├── src/
│   └── main/
│       └── java/
│           └── sistemalibreria/
│               ├── main.interfaces/         # Contratos para repositorios
│               ├── main.sistemalibreria.model/              # Clases Book, User, Loan, etc.
│               ├── services/           # Lógica de negocio (UserService, BookService, LoanService)
│               └── utils/              # Métodos auxiliares
├── .gitignore
├── pom.xml
└── 2024-Proyecto de Semestre.pdf       # Documento académico original
```

---

## 💡 Principios SOLID aplicados

| Principio | Aplicación en el proyecto |
|----------|-----------------------------|
| **S** - Responsabilidad única | Clases como `BookService`, `LoanService`, `UserService` están separadas |
| **O** - Abierto/Cerrado | Interfaces permiten extender sin modificar |
| **L** - Sustitución de Liskov | Las clases pueden intercambiarse si cumplen la interfaz |
| **I** - Segregación de Interfaces | Repositorios separados por entidad |
| **D** - Inversión de dependencias | Uso de main.interfaces en lugar de implementaciones directas |

---

## 🛠️ Tecnologías

- ☕ **Java 17**
- 🧠 **POO**
- 📦 **Maven**
- 🧪 Posible integración futura con **JUnit**
- 🖥️ **IDE recomendado**: IntelliJ IDEA

---

## 🧪 Ejecución del proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/inkevap/SistemaLibreria.git
   ```

2. Abrir el proyecto en IntelliJ IDEA u otro IDE compatible.

3. Asegurarse de tener Java 17 instalado.

4. Ejecutar desde la clase `main.Main` (a crear según interfaz gráfica o de consola deseada).

---

## 📄 Documentación

Consulta el documento [`2024-Proyecto de Semestre.pdf`](https://github.com/inkevap/SistemaLibreria/blob/develop/2024-Proyecto%20de%20Semestre.pdf) para más contexto del proyecto académico, motivación y criterios de evaluación.

---

## 🤝 Contribuciones

```bash
# Para contribuir:
1. Haz un fork
2. Crea una nueva rama: git checkout -b mi-nueva-funcionalidad
3. Realiza tus cambios y haz commit: git commit -m "Agrega nueva funcionalidad"
4. Sube tu rama: git push origin mi-nueva-funcionalidad
5. Abre un Pull Request
```

---

## 🧾 Licencia

Este proyecto es de carácter académico. Puede modificarse y adaptarse con fines educativos o personales.

---

> Hecho con 💡 por estudiantes de Ingeniería en Sistemas
