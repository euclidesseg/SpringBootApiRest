# Configuración de Spring Boot

Estas propiedades se encuentran en `application.properties` y permiten configurar diferentes aspectos de la aplicación.

Se pueden dividir principalmente en dos partes:

```text
Configuración de la aplicación
        ↓
Spring Boot

Configuración de persistencia
        ↓
Spring Data JPA / Hibernate
        ↓
Base de datos
```

---

## Configuración de la aplicación

### `spring.application.name`

Define el nombre de nuestra aplicación.

```properties
spring.application.name=SpringBootApiRest
```

---

## Configuración de la base de datos

Estas propiedades permiten configurar la conexión entre **Spring Boot y la base de datos**.

### `spring.datasource.url`

Indica la URL de conexión a la base de datos.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/DBGestion
```

* `jdbc` → tecnología utilizada para conectarse.
* `postgresql` → base de datos utilizada.
* `localhost` → servidor donde se encuentra la DB.
* `5432` → puerto de PostgreSQL.
* `DBGestion` → nombre de la base de datos.

### `spring.datasource.username`

Indica el usuario utilizado para conectarse a la base de datos.

```properties
spring.datasource.username=postgres
```
### `spring.datasource.password`

Indica la contraseña para conectarse a la base de datos.
```properties
spring.datasource.password=19962696Ee
```

### `spring.jpa.hibernate.ddl-auto`

Define qué debe hacer Hibernate con la **estructura de la base de datos**.

```properties
spring.jpa.hibernate.ddl-auto=update
```

`update` → Hibernate **crea o actualiza automáticamente las tablas** según las entidades definidas en Java.

> La base de datos debe existir previamente.

```properties
spring.jpa.hibernate.ddl-auto=none
```

`none` → Hibernate **no crea ni modifica la estructura de la base de datos**.



# `@RequestBody`

* Recibe datos que vienen **dentro del cuerpo (`body`) de la petición HTTP**.
* Se utiliza principalmente para enviar objetos completos al backend.
* Spring convierte automáticamente el JSON recibido en un objeto Java.
* En tu caso: `@RequestBody UsuarioModel usuario`.
* Ejemplo: `POST http://localhost:4001/usuario`
* El JSON del usuario viaja dentro del **body** de la petición.

---

# `@PathVariable`

* Obtiene un valor que forma parte de la **URL de la petición**.
* Se utiliza cuando el valor **identifica un recurso específico**.
* En tu código: `@GetMapping("/{id}")` + `@PathVariable("id")`.
* Ejemplo: `GET http://localhost:4001/usuario/1`
* Aquí `1` es el `id` y Spring lo asigna a `long id`.
* **Generalmente devuelve un solo objeto**, porque estamos solicitando un recurso específico.
* Ejemplo: `GET /usuario/1` → `"Dame el usuario cuyo ID es 1"`.

---

# `@RequestParam`

* Obtiene un valor enviado como **parámetro de consulta (query parameter)** en la URL.
* Se identifica porque aparece después de `?`.
* En tu código: `@RequestParam("idEstado") long idEstado`.
* Ejemplo: `GET http://localhost:4001/usuario/porEstado/query?idEstado=1`
* Para consultar por país: `GET http://localhost:4001/usuario/porPais/query?idPais=1`
* **Generalmente devuelve una lista**, porque estamos buscando todos los recursos que coincidan con un criterio.
* Ejemplo: `GET /usuario/porPais/query?idPais=1` → `"Dame todos los usuarios cuyo país sea 1"`.

> **Importante:** esto es una forma práctica de entenderlos, pero **no es una regla obligatoria**. Un `@PathVariable` también puede devolver una lista y un `@RequestParam` puede devolver un solo objeto. La diferencia principal está en **cómo utilizamos el valor de la URL**, no en el tipo de respuesta.
