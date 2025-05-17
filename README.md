# API de Personas y Películas Favoritas

Este proyecto es una API REST desarrollada con Spring Boot para gestionar personas y sus películas favoritas.

## Requisitos

- Java 17+
- Maven 3.9+

## Instalación y Ejecución

1. Clona el repositorio.
2. Ejecuta el siguiente comando para compilar y arrancar el proyecto:

```sh
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080`.

## Endpoints

### Personas

- **GET `/personas`**  
  Lista todas las personas ordenadas por apellido y nombre.

- **GET `/personas/{id}`**  
  Obtiene una persona por su ID.

- **GET `/personas/search?name={nombre}`**  
  Busca personas por nombre (case-insensitive).

- **POST `/personas`**  
  Crea una nueva persona.  
  **Body ejemplo:**
  ```json
  {
    "firstName": "Juan",
    "lastName": "Pérez",
    "birthDate": "1990-01-01",
    "hasInsurance": true,
    "favouriteMovies": []
  }
  ```

- **PUT `/personas/{id}`**  
  Actualiza una persona existente.  
  **Body igual que POST.**

- **DELETE `/personas/{id}`**  
  Elimina una persona por ID.

### Películas Favoritas de una Persona

- **GET `/personas/{id}/peliculas`**  
  Lista las películas favoritas de la persona con el ID dado.

- **POST `/personas/{id}/peliculas`**  
  Agrega una película favorita a la persona.  
  **Body ejemplo:**
  ```json
  {
    "title": "Matrix",
    "genre": "Ciencia Ficción"
  }
  ```
  **Nota:** El máximo de películas por persona está definido en `application.properties` (`max.movies.per.person`).

- **DELETE `/personas/{id}/peliculas/{titulo}`**  
  Elimina una película favorita por título (case-insensitive) de la persona.

## Configuración

El archivo [`src/main/resources/application.properties`](src/main/resources/application.properties) contiene la configuración principal, por ejemplo:

```
spring.application.name=personas
max.movies.per.person=5
```

## Pruebas

Para ejecutar los tests:

```sh
./mvnw test
```

---

**Autor:**  
Gabriel Omar Lazo
