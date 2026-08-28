# JPA (Java Persistence API)

## 1. ¿Qué es JPA?

**JPA (Java Persistence API)** es una **especificación de Java** que define cómo trabajar con bases de datos relacionales utilizando objetos Java.

Su objetivo principal es facilitar el almacenamiento, consulta, actualización y eliminación de objetos Java en una base de datos.

En otras palabras:

```text
Objetos Java  <----->  Tablas de Base de Datos
```

Esta técnica se conoce como:

**ORM (Object-Relational Mapping)**

---

## 2. ¿Qué significa Persistence?

La **persistencia** consiste en guardar información de una aplicación para que no se pierda cuando esta termina su ejecución.

Por ejemplo:

```text
Aplicación
    ↓
Objeto Customer
    ↓
Base de datos
    ↓
Tabla CUSTOMER
```

Si guardamos:

```java
Customer customer = new Customer();
customer.setName("Juan");
customer.setEmail("juan@email.com");
```

La información puede terminar almacenada en una tabla:

```text
CUSTOMER
--------------------------------
ID    NAME    EMAIL
1     Juan    juan@email.com
```

---
# Hibernate

**Hibernate** es una implementación de **JPA** que se encarga de realizar realmente la comunicación entre los objetos Java y la base de datos.

Mientras **JPA define las reglas**, **Hibernate las implementa**.

```text
JPA
 ↓
Define cómo trabajar con la persistencia

Hibernate
 ↓
Implementa esas reglas y se comunica con la base de datos
```
# Controller

Un **Controller (controlador)** es una clase encargada de recibir y procesar las **peticiones HTTP** que llegan a nuestra aplicación.

Es uno de los puntos de entrada de una petición.

```text
Cliente
   ↓
Petición HTTP
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Base de datos
```

En Spring Boot, una clase se convierte en un controlador utilizando la anotación:

```java
@RestController
public class CustomerController {
}
```

---

## Anotaciones importantes

### `@RestController`

Indica que una clase es un **controlador REST** y que sus métodos pueden devolver directamente datos, normalmente en formato JSON.

```java
@RestController
public class CustomerController {
}
```

---

### `@RequestMapping`

Permite definir una **ruta base** para las peticiones del controlador.

```java
@RequestMapping("/customers")
```

Por ejemplo:

```text
/customers
```

Las rutas de los métodos del controlador pueden utilizar esta ruta como base.

---

### `@GetMapping`

Indica que un método responde a una petición HTTP **GET**.

```java
@GetMapping("/all")
public List<Customer> getCustomers() {
    // ...
}
```

La petición sería:

```text
GET /customers/all
```

---

### `@PostMapping`

Indica que un método responde a una petición HTTP **POST**, normalmente utilizada para crear un nuevo recurso.

```java
@PostMapping
public Customer createCustomer(@RequestBody Customer customer) {
    // ...
}
```

---

### `@PutMapping`

Indica que un método responde a una petición HTTP **PUT**, normalmente utilizada para actualizar un recurso.

```java
@PutMapping
public Customer updateCustomer(@RequestBody Customer customer) {
    // ...
}
```

---

### `@DeleteMapping`

Indica que un método responde a una petición HTTP **DELETE**, normalmente utilizada para eliminar un recurso.

```java
@DeleteMapping("/{id}")
public void deleteCustomer(@PathVariable Long id) {
    // ...
}
```

---

### `@RequestBody`

Indica que los datos enviados en el **cuerpo de la petición HTTP** deben convertirse en un objeto Java.

```java
@PostMapping
public Customer createCustomer(@RequestBody Customer customer) {
    // ...
}
```

Por ejemplo, el cliente puede enviar:

```json
{
    "name": "Juan",
    "email": "juan@email.com"
}
```

Spring convierte estos datos en un objeto `Customer`.

---

### `@PathVariable`

Permite obtener un valor directamente desde la URL.

```java
@GetMapping("/{id}")
public Customer getCustomer(@PathVariable Long id) {
    // ...
}
```

Petición:

```text
GET /customers/10
```

Entonces:

```text
id = 10
```

---

### `@RequestParam`

Permite obtener parámetros enviados en la URL.

```java
@GetMapping
public Customer getCustomer(@RequestParam Long id) {
    // ...
}
```

Petición:

```text
GET /customers?id=10
```

Entonces:

```text
id = 10
```

---

# Service

Un **Service (servicio)** contiene la **lógica de negocio** de nuestra aplicación.

Se utiliza para separar las reglas de negocio del Controller.

```text
Controller
    ↓
Service
    ↓
Repository
```

En Spring Boot se utiliza normalmente `@Service`.

```java
@Service
public class CustomerService {

    public Customer createCustomer(Customer customer) {
        // Lógica de negocio
        return customer;
    }
}
```

**Idea principal:**

> El Service se encarga de **qué debe hacer la aplicación**.

---

# Repository

Un **Repository (repositorio)** se encarga de **interactuar con la base de datos**.

En Spring Data JPA podemos utilizar `JpaRepository` para obtener operaciones como guardar, buscar, actualizar y eliminar.

```java
@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}
```

Por ejemplo:

```java
customerRepository.save(customer);
customerRepository.findById(1L);
```

**Idea principal:**

> El Repository se encarga de **cómo acceder a los datos**.
